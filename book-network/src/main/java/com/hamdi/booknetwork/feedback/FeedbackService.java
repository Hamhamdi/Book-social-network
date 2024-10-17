package com.hamdi.booknetwork.feedback;

import com.hamdi.booknetwork.book.Book;
import com.hamdi.booknetwork.book.BookRepository;
import com.hamdi.booknetwork.exception.OperationNotPermittedException;
import com.hamdi.booknetwork.user.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FeedbackService {

    private final BookRepository bookRepository;
    public Integer save(FeedbackRequest request, Authentication connectedUser) {
        Book book = bookRepository.findById(request.bookId())
                .orElseThrow(() -> new EntityNotFoundException("No book found with the ID:: "+ request.bookId()));

        if(book.isArchived() || !book.isShareable()){
            throw new OperationNotPermittedException("You cannot give a feedback for an archived or not shareable book !");
        }

        User user = ((User) connectedUser.getPrincipal() );
        if (Objects.equals(book.getOwner().getId(), user.getId())){
            // throw an exception cannot borrow my own book
            throw new OperationNotPermittedException("You cannot borrow or return your own book");
        }
        return null;
    }
}
