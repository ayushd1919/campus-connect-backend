-- DLOC Tracks for Information Technology Department (ID: 2)
INSERT INTO `elective_tracks` (`name`, `department_id`) VALUES
('AI and Robotics', 2),
('IoT and Data Analytics', 2),
('Information Security and Forensics', 2),
('Bioinformatics', 2);

-- Second Year - CORE Subjects (IT Dept)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Engineering Mathematics III', 'IT201', 2, 'CORE', 3, NULL),
('Data Structure and Analysis of Algorithm', 'IT202', 2, 'CORE', 3, NULL),
('Database Management System', 'IT203', 2, 'CORE', 3, NULL),
('Operating Systems', 'IT204', 2, 'CORE', 3, NULL),
('Communication Engineering', 'IT205', 2, 'CORE', 3, NULL),
('Programming Lab I (Python)', 'IT206', 2, 'CORE', 3, NULL),
('Engineering Mathematics IV', 'IT207', 2, 'CORE', 4, NULL),
('Automata Theory and System Software', 'IT208', 2, 'CORE', 4, NULL),
('Computer Network and Security', 'IT209', 2, 'CORE', 4, NULL),
('Computer Architecture and Logic Design', 'IT210', 2, 'CORE', 4, NULL),
('Personal Finance Management', 'IT211', 2, 'CORE', 4, NULL),
('Innovation and Entrepreneurship', 'IT212', 2, 'CORE', 4, NULL),
('Programming Lab II (Web)', 'IT213', 2, 'CORE', 4, NULL);

-- Third Year - CORE Subjects (IT Dept)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Machine Intelligence', 'IT301', 2, 'CORE', 5, NULL),
('Microprocessor and Microcontroller', 'IT302', 2, 'CORE', 5, NULL),
('Professional Communication II', 'IT303', 2, 'CORE', 5, NULL),
('Human Values and Social Ethics', 'IT304', 2, 'CORE', 5, NULL),
('Programming Lab III (Android)', 'IT305', 2, 'CORE', 5, NULL),
('Software Engineering and Project Management', 'IT305', 2, 'CORE', 6, NULL),
('Data Mining and Business Intelligence', 'IT306', 2, 'CORE', 6, NULL),
('Major Project I', 'IT391', 2, 'CORE', 6, NULL);

-- Final Year - CORE Subjects (IT Dept)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Cloud Computing', 'IT401', 2, 'CORE', 7, NULL),
('Data Science and Visualization', 'IT402', 2, 'CORE', 7, NULL),
('Skill Lab (DevOps)', 'IT403', 2, 'CORE', 7, NULL),
('Major Project II', 'IT492', 2, 'CORE', 7, NULL);

-- DLOC Subjects (Linked to their respective tracks)
-- DLOC I (Sem 5)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Image and Video Processing', 'IT311', 2, 'DLOC', 5, (SELECT id FROM elective_tracks WHERE name='AI and Robotics')),
('Wireless Technology and 5G', 'IT312', 2, 'DLOC', 5, (SELECT id FROM elective_tracks WHERE name='IoT and Data Analytics')),
('Cryptography and Security', 'IT313', 2, 'DLOC', 5, (SELECT id FROM elective_tracks WHERE name='Information Security and Forensics')),
('Fundamentals of Computational Biology', 'IT314', 2, 'DLOC', 5, (SELECT id FROM elective_tracks WHERE name='Bioinformatics'));

-- DLOC II (Sem 6)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Genetic Algorithms and Fuzzy Systems', 'IT321', 2, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='AI and Robotics')),
('Internet of Everything', 'IT322', 2, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='IoT and Data Analytics')),
('Cyber Security', 'IT323', 2, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Information Security and Forensics')),
('Introduction to Bioinformatics', 'IT324', 2, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Bioinformatics'));

-- DLOC III (Sem 6)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Deep Learning', 'IT331', 2, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='AI and Robotics')),
('Big Data Analytics', 'IT332', 2, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='IoT and Data Analytics')),
('Penetration Testing', 'IT333', 2, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Information Security and Forensics')),
('Computational Genomics', 'IT334', 2, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Bioinformatics'));

-- DLOC IV (Sem 7)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Natural Language Processing', 'IT441', 2, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='AI and Robotics')),
('Industrial IOT', 'IT442', 2, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='IoT and Data Analytics')),
('Digital Forensics', 'IT443', 2, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Information Security and Forensics')),
('Structural Bioinformatics', 'IT444', 2, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Bioinformatics'));

-- DLOC V (Sem 7)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Computer Vision', 'IT451', 2, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='AI and Robotics')),
('Information Retrieval', 'IT452', 2, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='IoT and Data Analytics')),
('Multimedia Forensics', 'IT453', 2, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Information Security and Forensics')),
('Systems Biology', 'IT454', 2, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Bioinformatics'));