package spring_excr.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_excr.models.Town;
import spring_excr.repositories.TownRepository;
import spring_excr.services.TownService;

@Service
public class TownServiceImpl implements TownService{
    private TownRepository townRepository;

    @Autowired

    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    public void save(Town town) {
        this.townRepository.save(town);
    }
}
