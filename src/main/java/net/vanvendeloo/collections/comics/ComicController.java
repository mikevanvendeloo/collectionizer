package net.vanvendeloo.collections.comics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/comic")
public class ComicController {

    @Autowired
    private ComicRepository comicRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Comic> getAll() {
        return comicRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Comic create(@RequestBody Comic comic) {
        return comicRepository.save(comic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable String id) {
        comicRepository.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public Comic update(@PathVariable String id, @RequestBody Comic comic) {
        Comic originalComic = comicRepository.findOne(id);

        return comicRepository.save(Comic.builder().id(originalComic.getId()).issueNumber(comic.getIssueNumber()).description(comic.getDescription()).title
                (comic.getTitle()).build());
    }
}
