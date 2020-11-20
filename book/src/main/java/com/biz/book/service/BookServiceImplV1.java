package com.biz.book.service;

import com.biz.book.domain.BookVO;
import com.biz.book.persistence.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service(value = "bookServiceV1")
public class BookServiceImplV1 implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImplV1(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookVO> selectAll() {
        return bookRepository.findAll();
    }

    /**
     * Optional
     * 데이터가 없음을 null 이 아닌 어떤 명확한 근거를 바탕으로
     * 알고 싶다 라는 취지에서 새로 생성한 wrapper 클래스
     * VO 클래스를 감싸는 Wrapper 클래스
     *
     * 일반적으로 DB 핸들링에서 findById(Long id)를 수행한 후
     * id에 해당하는 데이터가 없을 경우 return 값이 null 이었다.
     * if(vo == null){
     *     log.debug("데이터가 없음")
     * }
     *
     * 위 조건식이 자바 1.7에서 뚫렸었기 때문에
     * Optional<>은 어떤 객체의 저장된 값이 null 인가를 비교하는 것을
     * 사용하지 않기 위해서 새롭게 등장한 class 이다.
     *
     * null 값을 비교하는 것 보다 연산 비용이 많이 든다.
     * 아직은 논란의 여지가 많다.
     * */
    @Override
    public BookVO findById(Long id) {
        Optional<BookVO> bookVO = bookRepository.findById(id);
        
        // 만약 findById() 수행하여 데이터가 없으면
        // 새로운 VO를 만들고 id 값을 -1로 세팅하여 리턴하라
        return bookVO.orElse(BookVO.builder().id(-1L).build());
    }

    @Override
    public int insert(BookVO bookVO) {
        bookRepository.save(bookVO);
        return 0;
    }

    @Override
    public int update(BookVO bookVO) {
        bookRepository.save(bookVO);
        return 0;
    }

    @Override
    public int delete(Long id) {
        bookRepository.deleteById(id);
        return 0;
    }
}
