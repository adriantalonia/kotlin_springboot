## Variables

### Difference between var and val

- **var** (Mutable variable): We can change the value of variable declared using var keyword later in the program.
- **val** (Immutable variable): We cannot change the value of variable which is declared using val keyword.

```kotlin
var salary = 30000
salary = 40000 //execute  

val language = "Java"
language = "Kotlin" //Error  
```

### Kotlin Data Type

Data type (basic type) refers to type and size of data associated with variables and functions. Data type is used for
declaration of memory location of variable which determines the features of data.

> In Kotlin, everything is an object, which means we can call member function and properties on any variable.

Kotlin built in data type are categorized as following different categories:

- Number
- Character
- Boolean
- Array
- String

### Number Types
**Number types** of data are those which hold only number type data variables. It is further categorized into different Integer and Floating point.

| Data Type | Bit Width (Size) | Data Range                      |
|:----------|:-----------------|:--------------------------------|
| `Byte`    | `8 bit`          | 128 to 127                      |
| `Short`        | `16 bit`               | 32768 to 32767                  |
| `Int`        | `32 bit`               | 2,147,483,648 to 2,147,483,647c |
| `Long`        | `64 bit`               |  -9,223,372,036,854,775,808 to +9,223,372,036,854,775,807                               |
| `Float`        | `32 bit`               |  1.40129846432481707e-45 to 3.40282346638528860e+38                               |
| `Double`        | `64 bit`               |  4.94065645841246544e-324 to 1.79769313486231570e+308                               |