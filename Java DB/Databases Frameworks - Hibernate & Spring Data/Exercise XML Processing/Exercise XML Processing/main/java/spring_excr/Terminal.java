package spring_excr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring_excr.dtos.export.*;
import spring_excr.dtos.imp.*;
import spring_excr.models.Category;
import spring_excr.models.Product;
import spring_excr.models.User;
import spring_excr.services.CategoryService;
import spring_excr.services.ProductService;
import spring_excr.services.UserService;
import spring_excr.utils.JsonSerializer;
import spring_excr.utils.XMLSerializer;

import javax.xml.bind.*;
import java.io.*;
import java.util.*;

import static spring_excr.utils.DTOConvertUtil.convert;

@Component
public class Terminal implements CommandLineRunner {
    private static final String USER_JSON_FILE_LOCATION = "src/main/resources/files/input/json/users.json";
    private static final String PRODUCTS_JSON_FILE_LOCATION = "src/main/resources/files/input/json/products.json";
    private static final String CATEGORIES_JSON_FILE_LOCATION = "src/main/resources/files/input/json/categories.json";
    private static final String PRODUCTS_IN_RANGE_EXPORT_JSON_FILE_LOCATION = "src/main/resources/files/output/json/products-in-range.json";
    private static final String SUCCESSFULLY_SOLD_PRODUCTS_EXPORT_JSON_FILE_LOCATION = "src/main/resources/files/output/json/users-sold-products.json";
    private static final String CATEGORIES_BY_PRODUCT_EXPORT_JSON_FILE_LOCATION = "src/main/resources/files/output/json/categories-by-products.json";
    private static final String USERS_AND_PRODUCTS_EXPORT_JSON_FILE_LOCATION = "src/main/resources/files/output/json/users-and-products.json";

    private static final String USER_XML_FILE_LOCATION = "src/main/resources/files/input/xml/users.xml";
    private static final String PRODUCTS_XML_FILE_LOCATION = "src/main/resources/files/input/xml/products.xml";
    private static final String CATEGORIES_XML_FILE_LOCATION = "src/main/resources/files/input/xml/categories.xml";
    private static final String PRODUCTS_IN_RANGE_EXPORT_XML_FILE_LOCATION = "src/main/resources/files/output/xml/products-in-range.xml";
    private static final String SUCCESSFULLY_SOLD_PRODUCTS_EXPORT_XML_FILE_LOCATION = "src/main/resources/files/output/xml/users-sold-products.xml";
    private static final String CATEGORIES_BY_PRODUCT_EXPORT_XML_FILE_LOCATION = "src/main/resources/files/output/xml/categories-by-products.xml";
    private static final String USERS_AND_PRODUCTS_EXPORT_XML_FILE_LOCATION = "src/main/resources/files/output/xml/users-and-products.xml";

    private JsonSerializer jsonSerializer;

    private XMLSerializer xmlSerializer;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;


    public Terminal(UserService userService, ProductService productService, CategoryService categoryService) {
        this.userService = userService;
        this.productService = productService;
        this.jsonSerializer = new JsonSerializer();
        this.categoryService = categoryService;
        this.xmlSerializer = new XMLSerializer();
    }

    @Override
    public void run(String... strings) throws Exception {
        this.importUsersXml();
        this.importCategoriesXml();
        this.importProductsXml();
        this.getProductsInPriceRangeWithNoBuyer();
        this.getSuccessfullySoldProducts();
        this.getCategoriesByProductsCount();
        this.getUsersWithSoldProducts();
    }

    private void importUserJson(UserDto userDto) throws IOException {
        User user = convert(userDto, User.class);
        userService.add(user);
    }

    private void importUsersJson() throws Exception {
        UserDto[] userDtos = jsonSerializer.deserialize(UserDto[].class, USER_JSON_FILE_LOCATION);
        for (UserDto userDto : userDtos) {
            importUserJson(userDto);
        }
    }

    private void importUsersXml() throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(UserWrapperDto.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        InputStream inputStream = new FileInputStream(USER_XML_FILE_LOCATION);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        UserWrapperDto users = (UserWrapperDto) unmarshaller.unmarshal(reader);
        List<UserDto> userDtos = users.getUsers();
        for (UserDto userDto : userDtos) {
            User user = convert(userDto, User.class);
            this.userService.add(user);
        }
    }

    private void importProductsJson() throws Exception {
        ProductDto[] productDtos = jsonSerializer.deserialize(ProductDto[].class, PRODUCTS_JSON_FILE_LOCATION);
        for (ProductDto productDto : productDtos) {
            importProductJson(productDto);
        }
    }

    private void importProductJson(ProductDto productDto) {
        Product product = convert(productDto, Product.class);
        randomizeData(product);
        generateCategories(product);
        this.productService.add(product);
        for (Category cat : product.getCategories()) {
            cat.getProducts().add(product);
            this.categoryService.add(cat);
        }
    }

    private void importProductsXml() throws IOException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ProductWrapperDto.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        FileInputStream inputStream = new FileInputStream(PRODUCTS_XML_FILE_LOCATION);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        ProductWrapperDto products = (ProductWrapperDto) unmarshaller.unmarshal(reader);
        List<ProductDto> productDtos = products.getProducts();
        for (ProductDto productDto : productDtos) {
            Product product = convert(productDto, Product.class);
            this.generateCategories(product);
            this.randomizeData(product);
            this.productService.add(product);
        }
    }

    private void importCategoriesXml() throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(CategoryWrapperDto.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        FileInputStream inputStream = new FileInputStream(CATEGORIES_XML_FILE_LOCATION);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        CategoryWrapperDto categories = (CategoryWrapperDto) unmarshaller.unmarshal(reader);
        List<CategoryDto> categoryDtos = categories.getCategories();
        for (CategoryDto categoryDto : categoryDtos) {
            Category category = convert(categoryDto, Category.class);
            this.categoryService.add(category);
        }
    }

    private void importCategoriesJson() throws Exception {
        CategoryDto[] categoryDtos = jsonSerializer.deserialize(CategoryDto[].class, CATEGORIES_JSON_FILE_LOCATION);
        for (CategoryDto categoryDto : categoryDtos) {
            importCategoryJson(categoryDto);
        }
    }

    private void importCategoryJson(CategoryDto categoryDto) {
        Category category = convert(categoryDto, Category.class);
        this.categoryService.add(category);
    }

    private void generateCategories(Product product) {
        Random random = new Random();
        HashSet<Category> categories = new HashSet<>();
        int rndInt = random.nextInt(this.categoryService.getAll().size());
        if (rndInt == 0) {
            rndInt++;
        }
        Category category = this.categoryService.getById(rndInt);
        categories.add(category);
        product.setCategories(categories);
        this.productService.add(product);
        category.setProduct(product);
        this.categoryService.add(category);
    }

    private void randomizeData(Product product) {
        Random random = new Random();
        int buyer = random.nextInt(this.userService.getAll().size());
        if (buyer < 49 && buyer != 0) {
            product.setBuyer(this.userService.getById(buyer));
        }
        int seller = 0;
        do {
            seller = random.nextInt(this.userService.getAll().size());
            if (seller == 0) {
                seller++;
            }
            product.setSeller(this.userService.getById(seller));
        } while (seller == buyer);
    }

    public void getProductsInPriceRangeWithNoBuyer() throws Exception {
        List<Product> products = this.productService.findByPriceBetweenAndBuyerIdIsNullOrderByPrice(500, 1000);
        List<ProductView> productViews = new ArrayList<>();
        for (Product product : products) {
            ProductView productView = convert(product, ProductView.class);
            productView.setSellerFirstNameAndLastName(product.getSeller().getFirstName() + " " + product.getSeller().getLastName());
            productViews.add(productView);
        }
        ProductWrapperView productView = new ProductWrapperView();
        productView.setProducts(productViews);
        JAXBContext jaxbContext = JAXBContext.newInstance(ProductWrapperView.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(productView, new File(PRODUCTS_IN_RANGE_EXPORT_XML_FILE_LOCATION));
    }

    public void getSuccessfullySoldProducts() throws Exception {
        List<User> users = this.userService.findAllUsersWithSoldProducts();
        List<UserView> userViews = new ArrayList<>();
        for (User user : users) {
            UserView userView = new UserView();
            userView.setFirstName(user.getFirstName());
            userView.setLastName(user.getLastName());
            for (Product product : user.getProductsForSelling()) {
                if (product.getBuyer() == null) {
                    continue;
                }
                SoldProductView soldProduct = new SoldProductView();
                soldProduct.setName(product.getName());
                soldProduct.setPrice(product.getPrice());
                soldProduct.setBuyerFirstName(product.getBuyer().getFirstName());
                soldProduct.setBuyerLastName(product.getBuyer().getLastName());
                userView.getSoldProducts().add(soldProduct);
            }
            userViews.add(userView);
        }
        UserWrapperView userView = new UserWrapperView();
        userView.setUsers(userViews);
        JAXBContext jaxbContext = JAXBContext.newInstance(UserWrapperView.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(userView, new File(SUCCESSFULLY_SOLD_PRODUCTS_EXPORT_XML_FILE_LOCATION));
    }

    private void getCategoriesByProductsCount() throws Exception {
        List<CategoryView> categories = this.categoryService.getCategoriesByProductsCount();
        CategoryWrapperView categoryView = new CategoryWrapperView();
        categoryView.setCategories(categories);
        JAXBContext jaxbContext = JAXBContext.newInstance(CategoryWrapperView.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(categoryView, new File(CATEGORIES_BY_PRODUCT_EXPORT_XML_FILE_LOCATION));
    }

    public void getUsersWithSoldProducts() throws Exception {
        List<User> users = this.userService.findAllUsersWithSoldProducts();
        UsersProductsWrapperView output = new UsersProductsWrapperView();
        output.setUsersCount(users.size());
        for (User user : users) {
            UserNameAgeView userView = new UserNameAgeView();
            if (user.getFirstName() == null) {
                userView.setFirstName(null);
            } else {
                userView.setFirstName(user.getFirstName());
            }

            if (user.getLastName() == null) {
                userView.setLastName(null);
            } else {
                userView.setLastName(user.getLastName());
            }
            if (user.getAge() == null) {
                userView.setAge(0);
            } else {
                userView.setAge(user.getAge());
            }

            SoldProductsView soldProductsView = new SoldProductsView();
            for (Product product : user.getProductsForSelling()) {
                if (product.getBuyer() == null) {
                    continue;
                }
                ProductNamePriceView productView = new ProductNamePriceView();
                productView.setName(product.getName());
                productView.setPrice(product.getPrice());
                soldProductsView.getProducts().add(productView);
            }
            soldProductsView.setCount(soldProductsView.getProducts().size());
            userView.setSoldProducts(soldProductsView);
            output.getUsers().add(userView);
        }
        JAXBContext jaxbContext = JAXBContext.newInstance(UsersProductsWrapperView.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(output, new File(USERS_AND_PRODUCTS_EXPORT_XML_FILE_LOCATION));
    }
}
