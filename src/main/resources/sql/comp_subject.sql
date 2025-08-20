-- DLOC Tracks for Computer Department (ID: 1)
INSERT INTO `elective_tracks` (`name`, `department_id`) VALUES
('Artificial Intelligence and Data Science', 1),
('Cloud and Cyber Security', 1),
('Robotics and Automation', 1),
('Human Computer Interaction', 1);

-- First Year - CORE Subjects (Common for all)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Engineering Mathematics I', 'FY101', 7, 'CORE', 1, NULL),
('Engineering Physics I', 'FY102', 7, 'CORE', 1, NULL),
('Engineering Chemistry I', 'FY103', 7, 'CORE', 1, NULL),
('C Programming', 'FY104', 7, 'CORE', 1, NULL),
('Basic Electrical Engineering', 'FY105', 7, 'CORE', 1, NULL),
('Basic Workshop -I', 'FY111', 7, 'CORE', 1, NULL),
('Engineering Mathematics II', 'FY115', 7, 'CORE', 2, NULL),
('Engineering Physics II', 'FY116', 7, 'CORE', 2, NULL),
('Engineering Chemistry II', 'FY117', 7, 'CORE', 2, NULL),
('Engineering Mechanics and Graphics', 'FY107', 7, 'CORE', 2, NULL),
('Java Programming', 'FY118', 7, 'CORE', 2, NULL),
('Professional Communication and Ethics-I', 'FY121', 7, 'CORE', 2, NULL),
('Basic Workshop -II', 'FY123', 7, 'CORE', 2, NULL);

-- Second Year - CORE Subjects (Computer Dept)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Engineering Mathematics III', 'CE201', 1, 'CORE', 3, NULL),
('Data structure', 'CE202', 1, 'CORE', 3, NULL),
('Database Management Systems', 'CE203', 1, 'CORE', 3, NULL),
('Digital Logic and Computer Architecture', 'CE204', 1, 'CORE', 3, NULL),
('Human Values and Social Ethics', 'CE205', 1, 'CORE', 3, NULL),
('Python Programming Lab', 'CE206', 1, 'CORE', 3, NULL),
('Engineering Mathematics IV', 'CE208', 1, 'CORE', 4, NULL),
('Design and Analysis of Algorithms', 'CE209', 1, 'CORE', 4, NULL),
('Operating Systems', 'CE210', 1, 'CORE', 4, NULL),
('Computer Graphics and virtual reality', 'CE211', 1, 'CORE', 4, NULL),
('Entrepreneurship', 'CE212', 1, 'CORE', 4, NULL),
('Web Programming', 'CE213', 1, 'CORE', 4, NULL),
('Personal Finance Management', 'CE214', 1, 'CORE', 4, NULL);

-- Third Year - CORE Subjects (Computer Dept)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Theory of Computation', 'CE301', 1, 'CORE', 5, NULL),
('Machine Learning', 'CE302', 1, 'CORE', 5, NULL),
('Microprocessor', 'CE303', 1, 'CORE', 5, NULL),
('Computer Network', 'CE304', 1, 'CORE', 5, NULL),
('Professional Communication and Ethics II', 'CE305', 1, 'CORE', 5, NULL),
('System Programming Compiler Construction', 'CE310', 1, 'CORE', 6, NULL),
('Artificial Intelligence', 'CE311', 1, 'CORE', 6, NULL),
('Project A', 'CE391', 1, 'CORE', 6, NULL);

-- Final Year - CORE Subjects (Computer Dept)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Deep Learning', 'CE401', 1, 'CORE', 7, NULL),
('Software Engineering and Project Management', 'CE402', 1, 'CORE', 7, NULL),
('Digital Image Processing', 'CE403', 1, 'CORE', 7, NULL),
('Project B', 'CE491', 1, 'CORE', 7, NULL);

-- DLOC Subjects (Linked to their respective tracks)
-- DLOC I (Sem 5)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Data Warehouse and Data Mining', 'CE306', 1, 'DLOC', 5, (SELECT id FROM elective_tracks WHERE name='Artificial Intelligence and Data Science')),
('Cryptography and System Security', 'CE307', 1, 'DLOC', 5, (SELECT id FROM elective_tracks WHERE name='Cloud and Cyber Security')),
('IoT and Embedded System for Automation', 'CE308', 1, 'DLOC', 5, (SELECT id FROM elective_tracks WHERE name='Robotics and Automation')),
('Augmented Reality and Virtual Real', 'CE309', 1, 'DLOC', 5, (SELECT id FROM elective_tracks WHERE name='Human Computer Interaction'));

-- DLOC II (Sem 6)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Big Data Analysis', 'CE312', 1, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Artificial Intelligence and Data Science')),
('Network & Cloud Security', 'CE313', 1, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Cloud and Cyber Security')),
('Robotics & Applications', 'CE314', 1, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Robotics and Automation')),
('User Experience Design', 'CE315', 1, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Human Computer Interaction'));

-- DLOC III (Sem 6)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Natural Language Processing', 'CE316', 1, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Artificial Intelligence and Data Science')),
('Ethical Hacking and Cyber Laws', 'CE317', 1, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Cloud and Cyber Security')),
('Control Systems for Automation', 'CE318', 1, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Robotics and Automation')),
('Human Computer Interaction', 'CE319', 1, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Human Computer Interaction'));

-- DLOC IV (Sem 7)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Data Science', 'CE404', 1, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Artificial Intelligence and Data Science')),
('Vulnerability Assessment and Penetration testing', 'CE405', 1, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Cloud and Cyber Security')),
('Industrial Automation', 'CE406', 1, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Robotics and Automation')),
('Mobile and Ubiquitous Computing', 'CE407', 1, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Human Computer Interaction'));

-- DLOC V (Sem 7)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Social Media Analytics', 'CE408', 1, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Artificial Intelligence and Data Science')),
('Digital Forensics', 'CE409', 1, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Cloud and Cyber Security')),
('Ethics in Robotics', 'CE410', 1, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Robotics and Automation')),
('Usability Engineering', 'CE411', 1, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Human Computer Interaction'));

