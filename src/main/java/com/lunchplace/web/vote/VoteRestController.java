package com.lunchplace.web.vote;

import com.lunchplace.dto.VoteTo;
import com.lunchplace.model.Vote;
import com.lunchplace.service.VoteService;
import com.lunchplace.web.SecurityUtil;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

import static org.slf4j.LoggerFactory.getLogger;

    @RestController
    @RequestMapping(value = "/rest/restaurants/votes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public class VoteRestController {
        private static final Logger log = getLogger(VoteRestController.class);

        private final VoteService voteService;

        public VoteRestController(VoteService voteService) {
            this.voteService = voteService;
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public ResponseEntity<Vote> createToWithLocation(@Valid @RequestBody VoteTo voteTo) {
            int userId = SecurityUtil.authUserId();
            Vote created = voteService.createOrUpdate(voteTo, userId);

            URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/rest/restaurants/votes/{id}")
                    .buildAndExpand(created.getId()).toUri();

            return ResponseEntity.created(uriOfNewResource).body(created);
        }

        @PutMapping
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void update( @Valid @RequestBody VoteTo voteTo) {
            int userId = SecurityUtil.authUserId();
            voteService.createOrUpdate(voteTo, userId);
        }
    }
