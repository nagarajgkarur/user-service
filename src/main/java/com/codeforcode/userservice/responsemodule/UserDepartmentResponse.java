package com.codeforcode.userservice.responsemodule;

import com.codeforcode.userservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDepartmentResponse {
    private User user;
    private Department department;
}
