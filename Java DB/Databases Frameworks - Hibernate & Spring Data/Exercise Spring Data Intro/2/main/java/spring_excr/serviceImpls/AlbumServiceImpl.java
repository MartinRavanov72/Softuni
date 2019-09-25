package spring_excr.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_excr.models.Album;
import spring_excr.repositories.AlbumRepository;
import spring_excr.services.AlbumService;

@Service
public class AlbumServiceImpl implements AlbumService{
    private AlbumRepository albumRepository;

    @Autowired
    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public void save(Album album) {
        this.albumRepository.save(album);
    }
}