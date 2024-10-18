package com.hamdi.booknetwork.feedback;


import com.hamdi.booknetwork.book.Book;
import com.hamdi.booknetwork.user.User;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class FeedbackMapper {
    public Feedback toFeedback(FeedbackRequest request) {
        return Feedback.builder()
                .note(request.note())
                .comment(request.Comment())
                .book(Book.builder()
                        .id(request.bookId())
                        .archived(false) // Not required to add a default value. it's just to make sure it'll not generate an error because of lombok primitive type ;)
                        .shareable(false)
                        .build()
                )
                .build();
    }

    public FeedbackResponse toFeedbackResponse(Feedback feedback, Integer id) {
    return FeedbackResponse.builder()
            .note(feedback.getNote())
            .comment(feedback.getComment())
            .ownFeedback(Objects.equals(feedback.getCreatedBy(), id))
            .build();
    }
}
