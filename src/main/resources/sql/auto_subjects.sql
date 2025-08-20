-- DLOC Tracks for Automobile Department (ID: 6)
INSERT INTO `elective_tracks` (`name`, `department_id`) VALUES
('Electric Vehicles', 6),
('Additive Manufacturing', 6),
('Motorsports Engineering', 6);

-- Second Year - CORE Subjects (Auto Dept)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Production Technology', 'AE201', 6, 'CORE', 3, NULL),
('Engineering Mathematics III', 'AE202', 6, 'CORE', 3, NULL),
('Strength of Materials', 'AE203', 6, 'CORE', 3, NULL),
('Thermodynamics', 'AE204', 6, 'CORE', 3, NULL),
('Engineering Metallurgy and Automotive Materials', 'AE205', 6, 'CORE', 3, NULL),
('Computer Aided Drafting', 'AE206', 6, 'CORE', 3, NULL),
('CNC and Additive Manufacturing Lab', 'AE207', 6, 'CORE', 3, NULL),
('Minor Project I', 'AE291', 6, 'CORE', 3, NULL),
('Automotive Engines and Combustion', 'AE208', 6, 'CORE', 4, NULL),
('Theory of Machines and Mechanisms', 'AE209', 6, 'CORE', 4, NULL),
('Fluid Mechanics and Machinery', 'AE210', 6, 'CORE', 4, NULL),
('Elements of Machine Design', 'AE211', 6, 'CORE', 4, NULL),
('Human Values and Social Ethics', 'AE212', 6, 'CORE', 4, NULL),
('Data Science', 'AE213', 6, 'CORE', 4, NULL),
('Minor Project II', 'AE292', 6, 'CORE', 4, NULL);

-- Third Year - CORE Subjects (Auto Dept)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Finite Element Analysis', 'AE301', 6, 'CORE', 5, NULL),
('Heat Transfer', 'AE302', 6, 'CORE', 5, NULL),
('Automotive Systems', 'AE303', 6, 'CORE', 5, NULL),
('Controls Engineering and Model based Systems', 'AE304', 6, 'CORE', 5, NULL),
('Minor Project III', 'AE391', 6, 'CORE', 5, NULL),
('Automotive Body and Chassis Systems', 'AE308', 6, 'CORE', 6, NULL),
('Automotive Vibrations', 'AE309', 6, 'CORE', 6, NULL),
('Professional Communication and Ethics II', 'AE310', 6, 'CORE', 6, NULL),
('Major Project I', 'AE392', 6, 'CORE', 6, NULL);

-- Final Year - CORE Subjects (Auto Dept)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Hybrid and Electric Vehicles', 'AE401', 6, 'CORE', 7, NULL),
('Vehicle Dynamics', 'AE402', 6, 'CORE', 7, NULL),
('Major Project II', 'AE491', 6, 'CORE', 7, NULL);

-- DLOC Subjects (Linked to their respective tracks)
-- DLOC I (Sem 5)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Electrical Machines', 'AE305', 6, 'DLOC', 5, (SELECT id FROM elective_tracks WHERE name='Electric Vehicles' AND department_id=6)),
('CAD for Additive Manufacturing', 'AE306', 6, 'DLOC', 5, (SELECT id FROM elective_tracks WHERE name='Additive Manufacturing' AND department_id=6)),
('Material Selection and Manufacturing', 'AE307', 6, 'DLOC', 5, (SELECT id FROM elective_tracks WHERE name='Motorsports Engineering' AND department_id=6));

-- DLOC II (Sem 6)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Power Electronics', 'AE311', 6, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Electric Vehicles' AND department_id=6)),
('Additive Manufacturing in Biomedical application', 'AE312', 6, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Additive Manufacturing' AND department_id=6)),
('Race Car Designing', 'AE313', 6, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Motorsports Engineering' AND department_id=6));

-- DLOC III (Sem 6)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Vehicle to Grid Technology', 'AE315', 6, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Electric Vehicles' AND department_id=6)),
('Design for Additive Manufacturing', 'AE316', 6, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Additive Manufacturing' AND department_id=6)),
('Electronics in Race Cars', 'AE314', 6, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Motorsports Engineering' AND department_id=6));

-- DLOC IV (Sem 7)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Automotive Embedded Systems', 'AE403', 6, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Electric Vehicles' AND department_id=6)),
('Automotive Product Design and Development', 'AE404', 6, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Additive Manufacturing' AND department_id=6)),
('Race Car Dynamics', 'AE405', 6, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Motorsports Engineering' AND department_id=6));

-- DLOC V (Sem 7)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Battery Management Systems', 'AE408', 6, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Electric Vehicles' AND department_id=6)),
('Advanced Materials for 3D Printing', 'AE409', 6, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Additive Manufacturing' AND department_id=6)),
('Simulation of Racing Cars', 'AE406', 6, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Motorsports Engineering' AND department_id=6));
