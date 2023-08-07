/*
 * Copyright 2019 Koushik R <rkoushik.14@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.grookage.qtrouper.core.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author koushik
 */
@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueueConfiguration {

    private static final String DEFAULT_NAMESPACE = "qtrouper";
    @Builder.Default
    private String namespace = DEFAULT_NAMESPACE;
    private String queueName;
    @Min(1)
    @Max(100)
    @Builder.Default
    private int concurrency = 3;
    @Min(1)
    @Max(100)
    @Builder.Default
    private int prefetchCount = 1;
    private boolean consumerDisabled;
    @Valid
    private RetryConfiguration retry;
    @Valid
    private SidelineConfiguration sideline;
    @Builder.Default
    private int maxPriority = 0;

    @JsonIgnore
    public boolean isConsumerEnabled() {
        return !consumerDisabled;
    }

}
