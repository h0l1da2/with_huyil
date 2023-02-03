package com.with.hyuil.dto.users;

<<<<<<< HEAD
<<<<<<< HEAD
import com.with.hyuil.model.BusinessVo;
=======
>>>>>>> 8cc50b4 (view, 어드민 빼고..)
=======
import com.with.hyuil.model.BusinessVo;
>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BusinessDto {

    private Long id;
    private String account;
<<<<<<< HEAD
<<<<<<< HEAD
    private String bankNumber;
    private String bank;

    public BusinessDto(BusinessVo businessVo) {
        this.id = businessVo.getId();
        this.account = businessVo.getAccount();
        this.bankNumber = businessVo.getBankNumber();
        this.bank = businessVo.getBank();
    }
=======
    private String bNumber;
    private String bank;
>>>>>>> 8cc50b4 (view, 어드민 빼고..)
=======
    private String bankNumber;
    private String bank;

    public BusinessDto(BusinessVo businessVo) {
        this.id = businessVo.getId();
        this.account = businessVo.getAccount();
        this.bankNumber = businessVo.getBankNumber();
        this.bank = businessVo.getBank();
    }
>>>>>>> 336955b (호텔폼 / 회원인포 기능 추가 (#23))
}
