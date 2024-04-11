package com.example.library.mapper;



import com.example.library.dtos.BookDto;
import com.example.library.model.entity.Book;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring",
        builder = @Builder(disableBuilder = true))
public interface BookMapper {

    @Mapping(target = "id",ignore = true)
    Book bookDtoToBook(BookDto bookDto);

    BookDto bookToBookDto(Book book);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id",ignore = true)
    Book updateBookFromBookDto(BookDto bookDto, @MappingTarget Book book);
}
