package org.feichai.voteman.domain;

import javax.persistence.*;

@Table(name = "tb_option_user")
public class OptionUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "option_id")
    private Integer optionId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return option_id
     */
    public Integer getOptionId() {
        return optionId;
    }

    /**
     * @param optionId
     */
    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }
}