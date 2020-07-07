package com.wurui.repository.core.dto;

import com.wurui.repository.core.domain.CorePost;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CorePostDTO extends CorePost {

    private static final long serialVersionUID = -7902870744187579521L;

    /**
     * 文章作者
     */
    private String username;
}
