package com.lanchplace.service;

import com.lanchplace.dto.VoteTo;
import com.lanchplace.model.Vote;
import com.lanchplace.repository.RestaurantRepository;
import com.lanchplace.repository.VoteRepository;
import com.lanchplace.util.ValidationUtil;
import com.lanchplace.util.exception.VoteException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static com.lanchplace.util.ValidationUtil.checkNotFoundWithId;

@Service
@RequiredArgsConstructor
public class VoteService {
    private static final LocalTime deadline = LocalTime.of(11, 0);

    private final VoteRepository voteRepository;
    private final RestaurantRepository restaurantRepository;

    public Vote createOrUpdate(VoteTo voteTo, int userId) {
        checkNotFoundWithId(restaurantRepository.getById(voteTo.getRestaurantId()), voteTo.getRestaurantId());
        Assert.notNull(voteTo, "VoteTo must not be null.");
        Vote vote = createNewFromTo(voteTo, userId);

        Vote existence = voteRepository.getFromUserFromDate(userId, LocalDate.now()).orElse(null);
        if (existence != null) {
            if (LocalTime.now().isBefore(deadline)) {
                vote.setId(existence.getId());
                return voteRepository.save(vote);
            } else {
                throw new VoteException("It's too late to voting.");
            }
        }
        return voteRepository.save(vote);
    }

    public void delete(int id, int userId) {
        checkNotFoundWithId(voteRepository.delete(id, userId), id);
    }

    public Vote get(int id, int userId) {
        return checkNotFoundWithId(voteRepository.findByIdAndUserId(id, userId), id);
    }

    public List<Vote> getAll() {
        return voteRepository.findAll();
    }


    public  Vote createNewFromTo(VoteTo voteTo, int userId) {
        return new Vote(null, LocalDate.now(), userId, voteTo.getRestaurantId());
    }
}

