package com.biz.bbs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

/**
 * JPA 기능을 사용하여 자동 table 생성을 하도록 설정
 * @Entity : JPA에서 논리적인 연산을 수행할 때 사용하도록 설정
 * @Table : 물리적 table을 만들 때 사용하도록 설정
 * tbl_bbs 라는 table을 필드변수를 칼럼값으로 하여 만들어 사용하겠다.
 * 유일한 값으로 자동으로 설정해라 (제너레이터 밸류)
 * 제너레이티드밸류는 마이에스큐엘이랑 잘어울림! 오라클에서는 사용 못함
 * b_id를 pk로 설정해라(@Id)
 * 일부사용하는 용도에따라 blob, clob를 쓸수있는데 가급적이면 사용하지말라 이런게있나 알려주는거임
 */
@Entity
@Table(name = "tbl_bbs")
public class BBsVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long b_id;

    @Column(columnDefinition = "VARCHAR(30)")
    private String b_writer;

    @Column(length = 30)
    private String b_date_time;

    @Column(columnDefinition = "VARCHAR(125)")
    private String b_subject;

    @Column(columnDefinition = "BLOB")
    private String b_content;

    private int b_count;
}
