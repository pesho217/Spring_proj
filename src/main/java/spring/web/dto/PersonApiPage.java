package spring.web.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class PersonApiPage<T> {
    private List<T> content;
    private PaginationMetadata pagination;
    public PersonApiPage(Page<T> springPage){
        this.content = springPage.getContent();
        this.pagination = PaginationMetadata.builder().
                currentPage(springPage.getPageable().getPageNumber()).
                pageSize(springPage.getPageable().getPageSize()).
                totalElements(springPage.getTotalElements()).
                totalPages(springPage.getTotalPages())
                .build();
    }
    @Data
    @Builder
    private static class PaginationMetadata{
        private Integer currentPage;
        private Integer pageSize;

        private Integer totalPages;
        private Long totalElements;
    }

}
