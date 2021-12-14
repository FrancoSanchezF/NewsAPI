/*
 * Copyright (c) 2021 Franco Sánchez Flores
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the
 * following conditions: The above copyright notice and this permission notice shall be included in all copies
 * or substantial portions of the Software. THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package cl.ucn.disc.dsm.fsanchez.newsapi;

import cl.ucn.disc.dsm.fsanchez.newsapi.model.News;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Te Controller of News
 *
 * @author Franco Sánchez-Flores
 */
@RestController
public class NewsController {

    /**
     * The Repo of News.
     */
    private final NewsRepository newsRepository;

    /**
     * The Constructor of NewsController.
     * @param newsRepository to use.
     */
    public NewsController(NewsRepository newsRepository){
        this.newsRepository = newsRepository;
    }

    /**
     *
     * @return all the News in the backend.
     */
    @GetMapping("/v1/news")
    public List<News> all() {
        // Equals to SELECT * FROM News;
        final List<News> theNews = this.newsRepository.findAll();
        // TODO: Show the news in console
        return theNews;
    }

    /**
     *
     * @param id og News to retrieve.
     * @return the News.
     */
    @GetMapping("v1/news/{id}")
    public News one(@PathVariable final Long id) {
        // FIXME: Change the RuntimeException to 404
        return this.newsRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("News Not Found :("));

    }

}
