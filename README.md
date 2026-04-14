# Multithreaded Web Server

This project demonstrates a **Multithreaded Web Server** implementation in Java with support for handling multiple client connections simultaneously. It includes the following functionalities:

- Multi-threading using both standard threads and thread pooling.
- Basic HTTP support for file sending and receiving.
- Graceful shutdown of server and threads.

## Repository Structure

```
Multithreaded Web-Server/
├── Client.java      # Client-side code for connecting to the server
├── Server.java      # Multithreaded server with file handling
├── ThreadPool/      # Optimized server implementation using thread pooling
    └── Server.java
```

## Features

### 1. **Client**
The client connects to the server and sends messages or files. It supports multiple concurrent clients through threading.

### 2. **Standard Multithreaded Server**
- Handles each client connection using a separate thread.
- Supports basic HTTP requests (`GET` for file retrieval, `POST` for file upload).
- Gracefully closes client connections.

### 3. **ThreadPool Server**
- Uses a thread pool for managing client connections efficiently.
- Improves performance and resource utilization.
- Handles HTTP requests for file operations and responses.

---

## Getting Started

### Prerequisites
- **Java JDK 8 or higher** installed.
- A Java IDE or text editor (e.g., IntelliJ IDEA, Eclipse, VS Code).

### Running the Project

#### 1. **Start the Server**

##### Standard Multithreaded Server
```bash
javac Server.java
java Server
```

##### ThreadPool Server
```bash
javac ThreadPool/Server.java
java ThreadPool.Server
```

#### 2. **Start the Client**
```bash
javac Client.java
java Client
```

### HTTP Requests Supported
- **GET**: Sends a predefined file (`sample.txt`) from the server to the client.
- **POST**: Accepts a file from the client and stores it on the server.

---

## Example Output

### Server
**Standard Multithreaded Server**
```plaintext
Server listening on port: 8080
Request received: GET / HTTP/1.1
File sent successfully: sample.txt
```

**ThreadPool Server**
```plaintext
Server listening on port: 8080
Accepted connection from: /127.0.0.1
Request received: POST / HTTP/1.1
File received successfully: received_file.txt
```

### Client
```plaintext
Response from the server: Hello from the server 127.0.0.1
```

---

## Future Enhancements
- Implement file encryption during transfer for security.
- Add support for handling larger files with chunked transfer encoding.
- Extend HTTP support with `DELETE` and `PUT` methods.
- Add logging for better debugging and tracking.

---

## Repository Link
[Multithreaded Web Server on GitHub](https://github.com/UjjwalMishra01/Webservers/tree/main/Multithreaded%20Web-Server)

---

Thank you for exploring the project! Contributions and feedback are welcome.
