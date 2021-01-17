package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.Tag;
import com.pluralsight.conferencedemo.repositories.TagRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tags")
public class TagController {
    @Autowired
    private TagRepository tagRepository;

    @GetMapping
    public List<Tag> list(){
        return tagRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Tag get(@PathVariable long id){
        return tagRepository.getOne(id);
    }

    @PostMapping
    public Tag create(@RequestBody final Tag tag){
        return tagRepository.saveAndFlush(tag);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id){
        tagRepository.deleteById(id);
    }

    @RequestMapping(value= "{id}", method = RequestMethod.PUT)
    public Tag update(@PathVariable long id, @RequestBody Tag tag){
        Tag existingTag = tagRepository.getOne(id);
        BeanUtils.copyProperties(tag, existingTag, "tag_id");
        return tagRepository.saveAndFlush(existingTag);
    }
}
