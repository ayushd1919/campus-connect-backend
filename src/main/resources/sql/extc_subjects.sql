-- DLOC Tracks for EXTC Department (ID: 4)
INSERT INTO `elective_tracks` (`name`, `department_id`) VALUES
('Smart Robotics and IoT driven Application Development', 4),
('Product Design', 4),
('VLSI Chip Design Technology', 4);

-- Second Year - CORE Subjects (EXTC Dept)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Engineering Mathematics III', 'ET201', 4, 'CORE', 3, NULL),
('Electronics Devices', 'ET202', 4, 'CORE', 3, NULL),
('Network Theory', 'ET203', 4, 'CORE', 3, NULL),
('Digital System Design', 'ET204', 4, 'CORE', 3, NULL),
('Signals and Systems', 'ET205', 4, 'CORE', 3, NULL),
('Python Programming II', 'ET206', 4, 'CORE', 3, NULL),
('Mini Project I', 'ET291', 4, 'CORE', 3, NULL),
('Engineering Mathematics IV', 'ET207', 4, 'CORE', 4, NULL),
('Electronic Communication Systems', 'ET208', 4, 'CORE', 4, NULL),
('Linear Integrated Circuits', 'ET209', 4, 'CORE', 4, NULL),
('Digital Signal Processing', 'ET210', 4, 'CORE', 4, NULL),
('Microprocessor & Microcontroller', 'ET211', 4, 'CORE', 4, NULL),
('Personal Finance Management', 'ET212', 4, 'CORE', 4, NULL),
('Mini Project II', 'ET292', 4, 'CORE', 4, NULL);

-- Third Year - CORE Subjects (EXTC Dept)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Digital Communication', 'ET301', 4, 'CORE', 5, NULL),
('Image Processing and Machine Vision', 'ET302', 4, 'CORE', 5, NULL),
('Embedded Systems', 'ET303', 4, 'CORE', 5, NULL),
('Programming (Java and Scripting)', 'ET304', 4, 'CORE', 5, NULL),
('Professional Communication and Ethics II', 'ET305', 4, 'CORE', 5, NULL),
('Wireless & Mobile Communication', 'ET313', 4, 'CORE', 6, NULL),
('Electromagnetic Wave & Radiating Systems', 'ET314', 4, 'CORE', 6, NULL),
('WM & AT Lab', 'ET315', 4, 'CORE', 6, NULL),
('R Programming', 'ET316', 4, 'CORE', 6, NULL),
('Final Year Project A', 'ET392', 4, 'CORE', 6, NULL);

-- Final Year - CORE Subjects (EXTC Dept)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Microwave and RF Design', 'ET401', 4, 'CORE', 7, NULL),
('Human Values and Social Ethics', 'ET402', 4, 'CORE', 7, NULL),
('Project B', 'ET491', 4, 'CORE', 7, NULL);

-- DLOC Subjects (Linked to their respective tracks)
-- Elective I (Sem 5)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('IOT Basics and Smart sensors', 'ET306', 4, 'DLOC', 5, (SELECT id FROM elective_tracks WHERE name='Smart Robotics and IoT driven Application Development' AND department_id=4)),
('PCB Design and Electronics Equipment Trouble shooting', 'ET307', 4, 'DLOC', 5, (SELECT id FROM elective_tracks WHERE name='Product Design' AND department_id=4)),
('Basics of VLSI Design', 'ET308', 4, 'DLOC', 5, (SELECT id FROM elective_tracks WHERE name='VLSI Chip Design Technology' AND department_id=4));

-- Elective II (Sem 6)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Data Processing and Coding', 'ET317', 4, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Smart Robotics and IoT driven Application Development' AND department_id=4)),
('TV and Video Engineering', 'ET318', 4, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Product Design' AND department_id=4)),
('Computer Communication and Network', 'ET319', 4, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='VLSI Chip Design Technology' AND department_id=4));

-- Elective III (Sem 6)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Robotics and Automation', 'ET320', 4, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Smart Robotics and IoT driven Application Development' AND department_id=4)),
('Electronic Product Design', 'ET321', 4, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Product Design' AND department_id=4)),
('Integrated Circuit Technology', 'ET322', 4, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='VLSI Chip Design Technology' AND department_id=4));

-- Elective IV (Sem 7)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('IoT driven App Development', 'ET403', 4, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Smart Robotics and IoT driven Application Development' AND department_id=4)),
('Communication System Design and Integration', 'ET404', 4, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Product Design' AND department_id=4)),
('Advanced VLSI', 'ET405', 4, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='VLSI Chip Design Technology' AND department_id=4));

-- Elective V (Sem 7)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Radar Engineering', 'ET406', 4, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Smart Robotics and IoT driven Application Development' AND department_id=4)),
('Advanced Networking Technologies', 'ET407', 4, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Product Design' AND department_id=4)),
('Optical Communication', 'ET408', 4, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='VLSI Chip Design Technology' AND department_id=4));