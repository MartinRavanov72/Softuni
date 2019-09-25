package spring_excr.serviceImpls;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring_excr.models.Author;
import spring_excr.repositories.AuthorRepository;
import spring_excr.services.AuthorService;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService{

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void saveAuthorIntoDb(Author author) {
        this.authorRepository.save(author);
    }

    @Override
    public void saveAuthorIntoDb(List<Author> authors) {
        this.authorRepository.save(authors);
    }


    @Override
    public List<Object[]> findAllByOrderByBooksDesc() {
        return this.authorRepository.findAllByOrderByBooksDesc();
    }

    @Override
    public List<Author> findAllByFirstNameEndingWith(String ending) {
        return this.authorRepository.findAllByFirstNameEndingWith(ending);
    }

}
