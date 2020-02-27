package am.bagiryan.sboot.dto;

import lombok.Data;

@Data
public class ConfirmDto {
    private String username;
    private String code;
    private String password;
}
