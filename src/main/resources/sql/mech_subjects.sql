-- DLOC Tracks for Mechanical Department (ID: 5)
INSERT INTO `elective_tracks` (`name`, `department_id`) VALUES
('Thermal Engineering and Energy Science', 5),
('Design Engineering', 5),
('Mechatronics & Robotics', 5),
('Non Destructive Testing', 5);

-- Second Year - CORE Subjects (Mech Dept)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Manufacturing Processes and Technology', 'MECH201', 5, 'CORE', 3, NULL),
('Mathematics III', 'MECH202', 5, 'CORE', 3, NULL),
('Strength of Materials', 'MECH203', 5, 'CORE', 3, NULL),
('Thermodynamics', 'MECH204', 5, 'CORE', 3, NULL),
('Engineering Metallurgy and Materials', 'MECH205', 5, 'CORE', 3, NULL),
('Human Values and Social Ethics', 'MECH206', 5, 'CORE', 3, NULL),
('Minor Project I', 'MECH291', 5, 'CORE', 3, NULL),
('Finite Element Analysis', 'MECH207', 5, 'CORE', 4, NULL),
('Theory of Machines and Mechanisms', 'MECH208', 5, 'CORE', 4, NULL),
('Fluid Mechanics and Machinery', 'MECH209', 5, 'CORE', 4, NULL),
('Data Science Lab', 'MECH210', 5, 'CORE', 4, NULL),
('Internet of Things', 'MECH211', 5, 'CORE', 4, NULL),
('Entrepreneurship', 'MECH212', 5, 'CORE', 4, NULL),
('Personal Finance Management', 'MECH290', 5, 'CORE', 4, NULL),
('Minor Project II', 'MECH292', 5, 'CORE', 4, NULL);

-- Third Year - CORE Subjects (Mech Dept)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Finite Element Analysis', 'ME301', 5, 'CORE', 5, NULL),
('Heat Transfer', 'ME302', 5, 'CORE', 5, NULL),
('Mechanical Measurements and Instrumentation', 'ME303', 5, 'CORE', 5, NULL),
('Professional Communication and Ethics II', 'ME304', 5, 'CORE', 5, NULL),
('Minor Project III', 'ME391', 5, 'CORE', 5, NULL),
('Mechatronics MDM', 'ME309', 5, 'CORE', 6, NULL),
('Machine Design I', 'ME310', 5, 'CORE', 6, NULL),
('Power Engineering', 'ME311', 5, 'CORE', 6, NULL),
('Major Project I', 'ME392', 5, 'CORE', 6, NULL);

-- Final Year - CORE Subjects (Mech Dept)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Production Planning and Systems', 'ME401', 5, 'CORE', 7, NULL),
('Refrigeration and Air Conditioning', 'ME402', 5, 'CORE', 7, NULL),
('Major Project II', 'ME491', 5, 'CORE', 7, NULL);

-- DLOC Subjects (Linked to their respective tracks)
-- DLOC I (Sem 5)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Advanced Fluid Mechanics', 'ME305', 5, 'DLOC', 5, (SELECT id FROM elective_tracks WHERE name='Thermal Engineering and Energy Science' AND department_id=5)),
('Design for Excellence', 'ME306', 5, 'DLOC', 5, (SELECT id FROM elective_tracks WHERE name='Design Engineering' AND department_id=5)),
('Control Systems', 'ME307', 5, 'DLOC', 5, (SELECT id FROM elective_tracks WHERE name='Mechatronics & Robotics' AND department_id=5)),
('Introduction to welding and NDT', 'ME308', 5, 'DLOC', 5, (SELECT id FROM elective_tracks WHERE name='Non Destructive Testing' AND department_id=5));

-- DLOC II (Sem 6)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Design of Heat Exchangers', 'ME312', 5, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Thermal Engineering and Energy Science' AND department_id=5)),
('Reliability Engineering', 'ME314', 5, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Design Engineering' AND department_id=5)),
('Micro Electro Mechanical Systems', 'ME316', 5, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Mechatronics & Robotics' AND department_id=5)),
('Non Destructive Testing Techniques I', 'ME318', 5, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Non Destructive Testing' AND department_id=5));

-- DLOC III (Sem 6)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Computational Fluid Dynamics', 'ME313', 5, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Thermal Engineering and Energy Science' AND department_id=5)),
('Failure Analysis', 'ME315', 5, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Design Engineering' AND department_id=5)),
('Signal Processing', 'ME317', 5, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Mechatronics & Robotics' AND department_id=5)),
('Radiographic and Ultrasonic Testing', 'ME319', 5, 'DLOC', 6, (SELECT id FROM elective_tracks WHERE name='Non Destructive Testing' AND department_id=5));

-- DLOC IV (Sem 7)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Thermal Design of Electronic Equipment', 'ME403', 5, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Thermal Engineering and Energy Science' AND department_id=5)),
('Design of Mechanical Systems', 'ME405', 5, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Design Engineering' AND department_id=5)),
('Robotics', 'ME407', 5, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Mechatronics & Robotics' AND department_id=5)),
('Acoustic Emission and Thermography', 'ME409', 5, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Non Destructive Testing' AND department_id=5));

-- DLOC V (Sem 7)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Computational Methods in Thermal Engineering', 'ME404', 5, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Thermal Engineering and Energy Science' AND department_id=5)),
('Engineering Vibrations', 'ME406', 5, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Design Engineering' AND department_id=5)),
('Modelling and Simulation', 'ME408', 5, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Mechatronics & Robotics' AND department_id=5)),
('Reliability and Life Assessment using NDT', 'ME410', 5, 'DLOC', 7, (SELECT id FROM elective_tracks WHERE name='Non Destructive Testing' AND department_id=5));
