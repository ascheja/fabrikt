package examples.enumExamples.models

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import javax.validation.Valid
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

data class BarBar(
    @param:JsonProperty("bar_prop")
    @get:JsonProperty("bar_prop")
    val barProp: String? = null
)

enum class ContentType(
    @JsonValue
    val value: String
) {
    APPLICATION_JSON("application/json"),

    APPLICATION_X_SOME_TYPE_JSON("application/x.some-type+json"),

    APPLICATION_X_SOME_OTHER_TYPE_JSON_VERSION_2("application/x.some-other-type+json;version=2");

    companion object {
        private val mapping: Map<String, ContentType> = values().associateBy(ContentType::value)

        fun fromValue(value: String): ContentType? = mapping[value]
    }
}

data class EnumHolder(
    @param:JsonProperty("array_of_enums")
    @get:JsonProperty("array_of_enums")
    val arrayOfEnums: List<EnumHolderArrayOfEnums>? = null,
    @param:JsonProperty("inlined_enum")
    @get:JsonProperty("inlined_enum")
    val inlinedEnum: EnumHolderInlinedEnum? = null,
    @param:JsonProperty("inlined_extensible_enum")
    @get:JsonProperty("inlined_extensible_enum")
    val inlinedExtensibleEnum: EnumHolderInlinedExtensibleEnum? = null,
    @param:JsonProperty("enum_ref")
    @get:JsonProperty("enum_ref")
    val enumRef: EnumObject? = null,
    @param:JsonProperty("extensible_enum_ref")
    @get:JsonProperty("extensible_enum_ref")
    val extensibleEnumRef: ExtensibleEnumObject? = null,
    @param:JsonProperty("list_enums")
    @get:JsonProperty("list_enums")
    val listEnums: List<ContentType>? = null
)

enum class EnumHolderArrayOfEnums(
    @JsonValue
    val value: String
) {
    ARRAY_ENUM_ONE("array_enum_one"),

    ARRAY_ENUM_TWO("array_enum_two");

    companion object {
        private val mapping: Map<String, EnumHolderArrayOfEnums> =
            values().associateBy(EnumHolderArrayOfEnums::value)

        fun fromValue(value: String): EnumHolderArrayOfEnums? = mapping[value]
    }
}

enum class EnumHolderInlinedEnum(
    @JsonValue
    val value: String
) {
    INLINED_ONE("inlined_one"),

    INLINED_TWO("inlined_two"),

    INLINED_THREE("inlined_three");

    companion object {
        private val mapping: Map<String, EnumHolderInlinedEnum> =
            values().associateBy(EnumHolderInlinedEnum::value)

        fun fromValue(value: String): EnumHolderInlinedEnum? = mapping[value]
    }
}

enum class EnumHolderInlinedExtensibleEnum(
    @JsonValue
    val value: String
) {
    INLINED_ONE("inlined_one"),

    INLINED_TWO("inlined_two"),

    INLINED_THREE("inlined_three");

    companion object {
        private val mapping: Map<String, EnumHolderInlinedExtensibleEnum> =
            values().associateBy(EnumHolderInlinedExtensibleEnum::value)

        fun fromValue(value: String): EnumHolderInlinedExtensibleEnum? = mapping[value]
    }
}

enum class EnumObject(
    @JsonValue
    val value: String
) {
    ONE("one"),

    TWO("two"),

    THREE("three");

    companion object {
        private val mapping: Map<String, EnumObject> = values().associateBy(EnumObject::value)

        fun fromValue(value: String): EnumObject? = mapping[value]
    }
}

enum class ExtensibleEnumObject(
    @JsonValue
    val value: String
) {
    ACTIVE("active"),

    INACTIVE("inactive");

    companion object {
        private val mapping: Map<String, ExtensibleEnumObject> =
            values().associateBy(ExtensibleEnumObject::value)

        fun fromValue(value: String): ExtensibleEnumObject? = mapping[value]
    }
}

data class FooBars(
    @param:JsonProperty("prop_one")
    @get:JsonProperty("prop_one")
    val propOne: List<FooBarsFoo>? = null,
    @param:JsonProperty("prop_two")
    @get:JsonProperty("prop_two")
    @get:Valid
    val propTwo: List<FooBarsBar>? = null
)

data class FooBarsBar(
    @param:JsonProperty("bar_prop")
    @get:JsonProperty("bar_prop")
    val barProp: String? = null
)

enum class FooBarsFoo(
    @JsonValue
    val value: String
) {
    X("X"),

    Y("Y");

    companion object {
        private val mapping: Map<String, FooBarsFoo> = values().associateBy(FooBarsFoo::value)

        fun fromValue(value: String): FooBarsFoo? = mapping[value]
    }
}

enum class FooFoo(
    @JsonValue
    val value: String
) {
    X("X"),

    Y("Y");

    companion object {
        private val mapping: Map<String, FooFoo> = values().associateBy(FooFoo::value)

        fun fromValue(value: String): FooFoo? = mapping[value]
    }
}
