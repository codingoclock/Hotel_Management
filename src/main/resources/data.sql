INSERT INTO Patient(date,created_at,id,email,gender,pat_name) VALUES
            ('2025-09-11',CURRENT_TIMESTAMP,1,'xyzz@gmail.com','Female','Diya Singh'),
            ('2025-08-12',CURRENT_TIMESTAMP,2,'justbitchin@gmail.com','Male','Bitchin Gupta'),
            ('2025-10-05', CURRENT_TIMESTAMP,3, 'arjun.test@gmail.com', 'Male', 'Arjun Kumar'),
            ('2025-11-20', CURRENT_TIMESTAMP,4, 'priya.s@gmail.com', 'Female', 'Priya Sharma');

INSERT INTO doctor (created_at,id,name,specialization,email) VALUES
            (CURRENT_TIMESTAMP,1,'Anisha','Neurosurgeon','anisha@gmail.com'),
            (CURRENT_TIMESTAMP,2,'Amit','Ortho','@amit1@gmail.com'),
            (CURRENT_TIMESTAMP,3,'Kartik','General', 'kart@gmail.com'),
            (CURRENT_TIMESTAMP,4,'Pritika','Heart','protik@gmail.com');