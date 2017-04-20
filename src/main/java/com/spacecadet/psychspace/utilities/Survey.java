package com.spacecadet.psychspace.utilities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Created by marleneshankar on 4/17/17.
 */

@Accessors(chain = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Survey {
    private String surveyKey;
    private String userKey;
    private String courseKey;
    private String title;
    private String dueDate;
}