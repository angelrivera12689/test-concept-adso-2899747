# Football Tournament Management System

## Project Overview
The Football Tournament Management System is designed to facilitate the administration and tracking of football tournaments at both amateur and professional levels. This system allows organizers to efficiently manage tournaments, teams, players, matches, referees, and detailed statistics.

---

## Data Model and Architecture

The system is structured into three main modules, each containing relevant entities with clearly defined attributes and relationships. All tables use **snake_case** naming conventions, singular table names, and **UUIDs** for primary keys. Audit fields are included for traceability.

### Common Audit Fields for All Entities
- `status` (active, inactive, deleted)  
- `created_at` (timestamp)  
- `created_by` (UUID or string)  
- `updated_at` (timestamp)  
- `updated_by` (UUID or string)  
- `deleted_at` (timestamp)  
- `deleted_by` (UUID or string)  

---

## Modules and Entities

### 1. Tournament Module

- **tournament**
  - `id` (UUID, Primary Key)  
  - `code` (string, unique)  
  - `name` (string)  
  - `start_date` (date)  
  - `end_date` (date)  
  - Audit fields  

- **stadium**
  - `id` (UUID, Primary Key)  
  - `name` (string)  
  - `location` (string)  
  - `capacity` (integer)  
  - Audit fields  

---

### 2. Teams and Players Module

- **team**
  - `id` (UUID, Primary Key)  
  - `name` (string)  
  - `tournament_id` (UUID, Foreign Key)  
  - `coach_id` (UUID, Foreign Key)  
  - Audit fields  

- **player**
  - `id` (UUID, Primary Key)  
  - `name` (string)  
  - `jersey_number` (integer, unique per team)  
  - `position` (string)  
  - `team_id` (UUID, Foreign Key)  
  - Audit fields  

- **coach**
  - `id` (UUID, Primary Key)  
  - `name` (string)  
  - Audit fields  

- **team_staff**  
  - `id` (UUID, Primary Key)  
  - `name` (string)  
  - `role` (string)  
  - `team_id` (UUID, Foreign Key)  
  - Audit fields  

---

### 3. Matches and Results Module

- **match**
  - `id` (UUID, Primary Key)  
  - `tournament_id` (UUID, Foreign Key)  
  - `home_team_id` (UUID, Foreign Key)  
  - `away_team_id` (UUID, Foreign Key)  
  - `stadium_id` (UUID, Foreign Key)  
  - `referee_id` (UUID, Foreign Key)  
  - `date` (datetime)  
  - Audit fields  

- **goal**
  - `id` (UUID, Primary Key)  
  - `match_id` (UUID, Foreign Key)  
  - `player_id` (UUID, Foreign Key)  
  - `minute` (integer)  
  - `goal_type` (string)  
  - Audit fields  

- **penalty**
  - `id` (UUID, Primary Key)  
  - `match_id` (UUID, Foreign Key)  
  - `player_id` (UUID, Foreign Key)  
  - `penalty_type` (string)  
  - `minute` (integer)  
  - `reason` (string)  
  - Audit fields  

- **referee**
  - `id` (UUID, Primary Key)  
  - `name` (string)  
  - Audit fields  

---

## Database Design Conventions

- Use `snake_case` for all table and column names.  
- Primary keys are UUIDs generated using `gen_random_uuid()` or equivalent.  
- Foreign Keys have `ON UPDATE CASCADE` and `ON DELETE` rules according to business logic.  
- Unique constraints applied where needed, e.g., `code` in `tournament`, `jersey_number` unique within a team.  
- Audit fields included in all tables to track creation, updates, and deletions.

---

## Advantages of This Structure

- **Scalability:** Easy to extend with new features and entities.  
- **Maintainability:** Clear modular separation simplifies debugging and updates.  
- **Consistency:** Standardized naming and auditing ensure reliable data management.  
- **Modularity:** Each module can be developed and tested independently.

---

## Next Steps

- Design and implement the database schema based on this model.  
- Develop API endpoints aligned with these entities and modules.  
- Implement the backend logic respecting modularity and clean code principles.

---

## Git Workflow

- `develop`: Main development branch.  
- `feature/hu-documentation`: Branch for documentation tasks.  
- `feature/hu-backend`: Branch for backend development.  
- `qa`: Quality assurance testing branch.  
- `release`: Branch to prepare production releases.  
- `main`: Production-ready code branch.  
