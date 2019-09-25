package com.example.demo;

import com.example.demo.models.dtos.binding.product.ProductCreateBindingModel;
import com.example.demo.models.dtos.binding.user.UserCreateBindingModel;
import com.example.demo.models.dtos.views.product.ProductInRangeViewModel;
import com.example.demo.services.product.ProductService;
import com.example.demo.services.user.UserService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StreamUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

@Component
@Transactional
public class Runner implements CommandLineRunner {


    private static final String USER_JSON_FILE_LOCATION = "/inputJson/users.json";
    private static final String PRODUCTS_JSON_FILE_LOCATION = "/inputJson/products.json";
    private static final String CATEGORIES_JSON_FILE_LOCATION = "/inputJson/categories.json";

    private final Gson gson;
    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public Runner(Gson gson,
                  UserService userService,
                  ProductService productService) {
        this.gson = gson;
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public void run(String... strings) throws Exception {
//       this.seedUsers();
//        this.seedProducts();
        List<ProductInRangeViewModel> viewModels = this.productService.getAllByRangeWithoutBuyer(500, 1000);
        String jsonOutput = this.gson.toJson(viewModels);
        this.writeToFile("/outputJson/products-in-range.json",jsonOutput);
    }

    private void writeToFile(String fileName, String src) {
        try {
            String mainPath = System.getProperty("user.dir") + "/src/main/resources";
            FileWriter writer = new FileWriter(new File(mainPath + fileName));
            writer.write(src);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void seedProducts() {
        InputStream productStream = this.loadData(PRODUCTS_JSON_FILE_LOCATION);
        String loaded = readAllData(productStream);
        Type listType = new TypeToken<List<ProductCreateBindingModel>>() {
        }.getType();
        List<ProductCreateBindingModel> products = this.gson.fromJson(loaded, listType);
        products.forEach(this::randomizeData);
        this.productService.save(products);
    }

    private void randomizeData(ProductCreateBindingModel model) {
        Random random = new Random();
        int buyer = random.nextInt(69);
        if (buyer <= 57) model.setBuyer(buyer);
        int seller = 0;
        do {
            seller = random.nextInt(57);
            model.setSeller(seller);
        } while (seller == buyer);
    }

    private void seedUsers() {
        InputStream usersStream = this.loadData(USER_JSON_FILE_LOCATION);
        String loaded = readAllData(usersStream);
        Type listType = new TypeToken<List<UserCreateBindingModel>>() {
        }.getType();
        List<UserCreateBindingModel> users = this.gson.fromJson(loaded, listType);
        this.userService.save(users);
    }

    private InputStream loadData(String fileLocation) {
        return Runner.class.getResourceAsStream(fileLocation);
    }

    private String readAllData(InputStream stream) {
        try {
            return StreamUtils.copyToString(stream, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
