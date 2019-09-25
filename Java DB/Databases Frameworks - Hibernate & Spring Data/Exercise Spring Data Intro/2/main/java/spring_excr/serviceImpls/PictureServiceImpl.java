package spring_excr.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_excr.models.Picture;
import spring_excr.repositories.PictureRepository;
import spring_excr.services.PictureService;

@Service
public class PictureServiceImpl implements PictureService{
    private PictureRepository pictureRepository;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public void save(Picture picture) {
        this.pictureRepository.save(picture);
    }
}
