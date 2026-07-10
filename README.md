## Architecture & Validation Specifications

### Product Data Transfer Object (DTO)
* **Implementation:** Integrated `ProductDTO` utilizing Jakarta Bean Validation annotations (`@NotBlank`, `@Positive`) to enforce strict request body constraints at the controller boundary.
* **Data Flow:** Incoming payloads are automatically validated before entering the business logic layer, preventing corrupt or malformed data persistence.

### Global Exception Handling
* **Mechanism:** Implemented a centralized `GlobalExceptionHandler` annotated with `@RestControllerAdvice` to intercept controller-level exceptions globally.
* **Error Resolution:** Specifically handles `MethodArgumentNotValidException` to capture validation failures. It maps errors into a standardized, serializable JSON response structure containing metadata: timestamp, HTTP status code, error type, and precise field-level validation details.

### Rules Businesses
I created user's validation: Email do validate that its field don't come null and using regrex the field can validate the email structure
Username get different validations like, the field don't come null, also validate the field's length at least 4 characters and max 20 character, This field don't accept specific words like "admin" or "root" also deny the names starts and ends with a '.', using a regrex the fild validate if bring a username with [a-z] adn [0-9]

### Global Exception User
*  **Mechanism:** Implemented a centralized `GlobalExceptionUser` annotated with '@RestControllerAdvice' to intercept controller-level exceptions globally
* **Error Resolution:** Specifically handles `MethodArgumentNotValidException` to capture validation failures. It maps errors into a standardized, serializable JSON response structure containing metadata: timestamp, HTTP status code, error type, and precise field-level validation details.
