CREATE TABLE user (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      username VARCHAR(50) NOT NULL,
                      password VARCHAR(100) NOT NULL,
                      faculty VARCHAR(100),
                      course INT,
                      group_number VARCHAR(50)
);

CREATE TABLE teacher (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(100) NOT NULL,
                         department VARCHAR(100)
);

CREATE TABLE course (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(100) NOT NULL
);

CREATE TABLE schedule (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          subject VARCHAR(100) NOT NULL,
                          date_time TIMESTAMP,
                          room VARCHAR(50),
                          status VARCHAR(50),
                          user_id BIGINT,
                          teacher_id BIGINT,
                          course_id BIGINT,
                          FOREIGN KEY (user_id) REFERENCES user(id),
                          FOREIGN KEY (teacher_id) REFERENCES teacher(id),
                          FOREIGN KEY (course_id) REFERENCES course(id)
);

CREATE TABLE teacher_comments (
                                  teacher_id BIGINT,
                                  comment VARCHAR(255),
                                  FOREIGN KEY (teacher_id) REFERENCES teacher(id)
);