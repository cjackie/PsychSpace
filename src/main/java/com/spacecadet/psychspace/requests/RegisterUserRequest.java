package com.spacecadet.psychspace.requests;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Created by aliao on 3/27/2017.
 */
@Accessors(chain = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserRequest {
    @NotNull
    private String email;
    private String firstName;
    private String lastName;
    private Date DoB;
    @NotNull
    private String password;
}