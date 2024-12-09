CREATE TABLE budgetbuddy.room (
    Id INT PRIMARY KEY NOT NULL,
    room_name varchar (255) NOT NULL,
    group_goal numeric (10,2) NOT NULL,
	start_date TIMESTAMP NOT NULL,
	end_date TIMESTAMP NOT NULL,
	period_type varchar (255) NOT NULL,
	date_created TIMESTAMP NOT NULL,
	date_updated TIMESTAMP NOT NULL,
    is_deleted INT DEFAULT 0
);