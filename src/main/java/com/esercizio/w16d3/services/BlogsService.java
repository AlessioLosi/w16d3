package com.esercizio.w16d3.services;

import com.esercizio.w16d3.Payload.BlogpostPayload;
import com.esercizio.w16d3.entities.Blogpost;
import com.esercizio.w16d3.exceptions.NotFoundException;
import com.esercizio.w16d3.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

@Service
public class BlogsService {
    private final List<Blogpost> blogs = new ArrayList<>();
    @Autowired
    private BlogPostRepository blogPostRepository;

    public BlogpostPayload save(BlogpostPayload blogpost) {
        Random rndm = new Random();
        blogpost.setCover("https://picsum.photos/200/300");
        this.blogs.add(new Blogpost());
        return blogpost;
    }

    public Page<Blogpost> findAll(int page, int size, String sortBy) {
        if (size > 100) size = 20;
        Pageable pageable = (Pageable) PageRequest.of(page, size, Sort.by(sortBy));

        return this.blogPostRepository.findAll(pageable);
    }

    public Blogpost findById(int id) {
        Blogpost found = null;

        for (Blogpost blogpost : blogs) {
            if (blogpost.getId() == id)
                found = blogpost;
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;
    }

    public void findByIdAndDelete(int id) {
        ListIterator<Blogpost> iterator = this.blogs.listIterator();

        while (iterator.hasNext()) {
            Blogpost currentBlog = iterator.next();
            if (currentBlog.getId() == id) {
                iterator.remove();
            }
        }
    }

    public Blogpost findByIdAndUpdate(int id, Blogpost body) {
        Blogpost found = null;

        for (Blogpost currentBlog : blogs) {
            if (currentBlog.getId() == id) {
                found = currentBlog;
                found.setCover(body.getCover());
                found.setCategory(body.getCategory());
                found.setContent(body.getCover());
                found.setReadingTime(body.getReadingTime());
                found.setId(id);
            }
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;

    }
}
