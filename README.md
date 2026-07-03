## Architecture & Validation Specifications

### Product Data Transfer Object (DTO)
* **Implementation:** Integrated `ProductDTO` utilizing Jakarta Bean Validation annotations (`@NotBlank`, `@Positive`) to enforce strict request body constraints at the controller boundary.
* **Data Flow:** Incoming payloads are automatically validated before entering the business logic layer, preventing corrupt or malformed data persistence.

### Global Exception Handling
* **Mechanism:** Implemented a centralized `GlobalExceptionHandler` annotated with `@RestControllerAdvice` to intercept controller-level exceptions globally.
* **Error Resolution:** Specifically handles `MethodArgumentNotValidException` to capture validation failures. It maps errors into a standardized, serializable JSON response structure containing metadata: timestamp, HTTP status code, error type, and precise field-level validation details.