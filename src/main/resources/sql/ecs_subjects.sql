-- DLOC Tracks for ECS Department (ID: 3)
INSERT INTO `elective_tracks` (`name`, `department_id`) VALUES
('AIML', 3),
('Data Analytics', 3),
('High Performance Computing', 3),
('IOT', 3);

-- Second Year - CORE Subjects (ECS Dept)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Engineering Mathematics III', 'EC201', 3, 'CORE', 3, NULL),
('Analog Electronics Circuits', 'EC202', 3, 'CORE', 3, NULL),
('Digital Circuits & System Design', 'EC203', 3, 'CORE', 3, NULL),
('Data Structures & Algorithms', 'EC204', 3, 'CORE', 3, NULL),
('Database Management System', 'EC205', 3, 'CORE', 3, NULL),
('Personal Finance Management', 'EC206', 3, 'CORE', 3, NULL),
('Human Values and Social Ethics', 'EC207', 3, 'CORE', 3, NULL),
('Engineering Mathematics IV', 'EC209', 3, 'CORE', 4, NULL),
('Analysis of Algorithms', 'EC210', 3, 'CORE', 4, NULL),
('Basics of VLSI Design', 'EC211', 3, 'CORE', 4, NULL),
('System Software & Operating Systems', 'EC212', 3, 'CORE', 4, NULL),
('Microprocessor and Microcontrollers', 'EC213', 3, 'CORE', 4, NULL),
('Entrepreneurship', 'EC214', 3, 'CORE', 4, NULL),
('Programming Lab I ( Java Programming)', 'EC291', 3, 'CORE', 4, NULL);

-- Third Year - CORE Subjects (ECS Dept)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Signals & Systems', 'EC301', 3, 'CORE', 5, NULL),
('Computer Networks', 'EC302', 3, 'CORE', 5, NULL),
('Professional Communication and Ethics II', 'EC303', 3, 'CORE', 5, NULL),
('Software Engineering', 'EC304', 3, 'CORE', 5, NULL),
('Programming Lab II(Web Programming)', 'EC391', 3, 'CORE', 5, NULL),
('Instrumentation and Control System', 'EC309', 3, 'CORE', 6, NULL),
('Computer Organization & Architecture', 'EC310', 3, 'CORE', 6, NULL),
('Software Testing & Quality Assurance', 'EC311', 3, 'CORE', 6, NULL),
('Project A', 'EC392', 3, 'CORE', 6, NULL);

-- Final Year - CORE Subjects (ECS Dept)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Image Processing & Machine Vision', 'EC401', 3, 'CORE', 7, NULL),
('Programming Lab III (R-Programming)', 'EC491', 3, 'CORE', 7, NULL),
('Multidisciplinary Minor Project', 'EC492', 3, 'CORE', 7, NULL),
('Project B', 'EC493', 3, 'CORE', 7, NULL);

-- DLOC Subjects (Linked to their respective tracks)
-- DLOC I (Sem 5)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Artificial Intelligence', 'EC305', 3, 'DLOC', 5, (SELECT id FROM elective_tracks WHERE name='AIML' AND department_id=3)),
('Advanced Database Management Systems + DWM', 'EC306', 3, 'DLOC', 5, (SELECT id FROM elective_tracks WHERE name='Data Analytics' AND department_id=3)),
('Advanced Operating System', 'EC307', 3, 'DLOC', 5, (SELECT id FROM elective_tracks WHERE name='High Performance Computing' AND department_id=3)),
('Embedded System Design & Basics of IOT', 'EC308', 3, 'DLOC', 5, (SELECT id FROM elective_tracks WHERE name='IOT' AND department_id=3));

-- DLOC II (Sem 6)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Foundations of Robotics', 'EC312', 3, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='AIML' AND department_id=3)),
('Cryptography and System Security', 'EC313', 3, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Data Analytics' AND department_id=3)),
('Mobile & Distributed Computing', 'EC314', 3, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='High Performance Computing' AND department_id=3)),
('Integrated Circuit Technology', 'EC315', 3, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='IOT' AND department_id=3));

-- DLOC III (Sem 6)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Machine Learning', 'EC316', 3, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='AIML' AND department_id=3)),
('Big Data Analytics', 'EC317', 3, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Data Analytics' AND department_id=3)),
('Parallel Computing Architecture', 'EC318', 3, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='High Performance Computing' AND department_id=3)),
('Wireless Networks', 'EC319', 3, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='IOT' AND department_id=3));

-- DLOC IV (Sem 7)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Advanced Robotics', 'EC402', 3, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='AIML' AND department_id=3)),
('Advanced Network Theory', 'EC403', 3, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Data Analytics' AND department_id=3)),
('Cloud Computing', 'EC404', 3, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='High Performance Computing' AND department_id=3)),
('Advanced VLSI Design', 'EC405', 3, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='IOT' AND department_id=3));

-- DLOC V (Sem 7)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Deep Learning', 'EC406', 3, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='AIML' AND department_id=3)),
('Data Science', 'EC407', 3, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Data Analytics' AND department_id=3)),
('High Performance Computing', 'EC408', 3, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='High Performance Computing' AND department_id=3)),
('Internet of Everything', 'EC409', 3, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='IOT' AND department_id=3));
