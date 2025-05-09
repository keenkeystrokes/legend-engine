// Copyright 2021 Goldman Sachs
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.finos.legend.engine.protocol.pure.v1.model.executionPlan.nodes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "_type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = EnumValidationContext.class, name = "enumValidationContext"),
        @JsonSubTypes.Type(value = ProtocolObjectValidationContext.class, name = "protocolObjectValidationContext")
})

// NOTE: due to plan generator producing duplicated _type field, we need to enable this
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ParameterValidationContext
{
    public String varName;

    public ParameterValidationContext()
    {
        // DO NOT DELETE: this resets the default constructor for Jackson
    }

    public abstract <T> T accept(ParameterValidationContextVisitor<T> validationContextVisitor);
}
