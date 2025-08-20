-- ILOC Tracks (Linked to Common Department ID: 7)
INSERT INTO `elective_tracks` (`name`, `department_id`) VALUES
('IP Management and Digital Business', 7),
('Business Management', 7),
('Bio Engineering', 7),
('Bio Instrumentation', 7),
('Engineering Design', 7),
('Sustainable Technologies', 7),
('Contemporary Studies', 7),
('Art and Journalism', 7),
('Applied Science', 7),
('Green Technologies', 7),
('Maintenance Engineering', 7),
('Life Skills', 7),
('Environment', 7),
('Safety', 7),
('Digital Business Management and Digital Marketing', 7),
('Business Analytics', 7);

-- ILOC Subjects (Linked to their respective tracks)
-- ILOC I (Sem 5)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('IPR and Patenting', 'IL360', 7, 'ILOC', 5, (SELECT id FROM elective_tracks WHERE name='IP Management and Digital Business')),
('E- Commerce and E-Business', 'IL361', 7, 'ILOC', 5, (SELECT id FROM elective_tracks WHERE name='Business Management')),
('Introduction to Bioengineering', 'IL362', 7, 'ILOC', 5, (SELECT id FROM elective_tracks WHERE name='Bio Engineering')),
('Biomedical Instrumentation', 'IL363', 7, 'ILOC', 5, (SELECT id FROM elective_tracks WHERE name='Bio Instrumentation')),
('Design of Experiments', 'IL364', 7, 'ILOC', 5, (SELECT id FROM elective_tracks WHERE name='Engineering Design')),
('Design for Sustainability', 'IL365', 7, 'ILOC', 5, (SELECT id FROM elective_tracks WHERE name='Sustainable Technologies')),
('Political Science', 'IL366', 7, 'ILOC', 5, (SELECT id FROM elective_tracks WHERE name='Contemporary Studies')),
('Visual Arts', 'IL367', 7, 'ILOC', 5, (SELECT id FROM elective_tracks WHERE name='Art and Journalism')),
('Modern Day Sensor Physics', 'IL368', 7, 'ILOC', 5, (SELECT id FROM elective_tracks WHERE name='Applied Science')),
('Energy Audit and Management', 'IL369', 7, 'ILOC', 5, (SELECT id FROM elective_tracks WHERE name='Green Technologies')),
('Maintenance of Electronics Equipment', 'IL370', 7, 'ILOC', 5, (SELECT id FROM elective_tracks WHERE name='Maintenance Engineering')),
('Cooking and Nutrition', 'IL371', 7, 'ILOC', 5, (SELECT id FROM elective_tracks WHERE name='Life Skills')),
('Environmental Management', 'IL372', 7, 'ILOC', 5, (SELECT id FROM elective_tracks WHERE name='Environment')),
('Vehicle Safety', 'IL373', 7, 'ILOC', 5, (SELECT id FROM elective_tracks WHERE name='Safety'));

-- ILOC II (Sem 6)
INSERT INTO `subjects` (`name`, `subject_code`, `department_id`, `type`, `semester`, `elective_track_id`) VALUES
('Digital Business Management and Digital Marketing', 'IL370', 7, 'ILOC', 6, (SELECT id FROM elective_tracks WHERE name='Digital Business Management and Digital Marketing')),
('Business Analytics', 'IL371', 7, 'ILOC', 6, (SELECT id FROM elective_tracks WHERE name='Business Analytics')),
('IPR and Patenting', 'IL372', 7, 'ILOC', 6, (SELECT id FROM elective_tracks WHERE name='IP Management and Digital Business')),
('Medical Image Processing', 'IL373', 7, 'ILOC', 6, (SELECT id FROM elective_tracks WHERE name='Bio Engineering')),
('Bio Mechanics', 'IL374', 7, 'ILOC', 6, (SELECT id FROM elective_tracks WHERE name='Bio Engineering')),
('Product Design', 'IL375', 7, 'ILOC', 6, (SELECT id FROM elective_tracks WHERE name='Engineering Design')),
('Technologies for Rural Development', 'IL376', 7, 'ILOC', 6, (SELECT id FROM elective_tracks WHERE name='Sustainable Technologies')),
('Economics', 'IL377', 7, 'ILOC', 6, (SELECT id FROM elective_tracks WHERE name='Contemporary Studies')),
('Journalism, Media and Communication studies', 'IL378', 7, 'ILOC', 6, (SELECT id FROM elective_tracks WHERE name='Art and Journalism')),
('Operation Research for Management', 'IL379', 7, 'ILOC', 6, (SELECT id FROM elective_tracks WHERE name='Applied Science')),
('Maintenance of Mechanical Equipment', 'IL380', 7, 'ILOC', 6, (SELECT id FROM elective_tracks WHERE name='Maintenance Engineering')),
('Physical Education', 'IL381', 7, 'ILOC', 6, (SELECT id FROM elective_tracks WHERE name='Life Skills')),
('Weather and Climate Informatics', 'IL382', 7, 'ILOC', 6, (SELECT id FROM elective_tracks WHERE name='Environment')),
('Vehicle Safety', 'IL383', 7, 'ILOC', 6, (SELECT id FROM elective_tracks WHERE name='Safety'));