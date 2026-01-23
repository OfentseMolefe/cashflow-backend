package com.shaper.CashFlow.DTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserModelDTO {
    private  Long id;
    private String email;
    private LocalDateTime created_at;
}
