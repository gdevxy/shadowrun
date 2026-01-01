-- Reset database - Remove all data from all tables
-- WARNING: This will delete ALL data in the database!

-- Disable triggers temporarily to avoid constraint issues
SET
session_replication_role = 'replica';

-- Truncate all tables with CASCADE to handle foreign key constraints
-- This is faster than DELETE and resets auto-increment counters

TRUNCATE TABLE session CASCADE;
TRUNCATE TABLE campaign_scene_section_dialog CASCADE;
TRUNCATE TABLE campaign_scene_section_property CASCADE;
TRUNCATE TABLE campaign_scene_section CASCADE;
TRUNCATE TABLE campaign_scene CASCADE;
TRUNCATE TABLE campaign CASCADE;

TRUNCATE TABLE character_background CASCADE;
TRUNCATE TABLE character CASCADE;

TRUNCATE TABLE location_property CASCADE;
TRUNCATE TABLE location CASCADE;

-- Re-enable triggers
SET
session_replication_role = 'origin';

-- Verify all tables are empty
DO
$$
DECLARE
campaign_count INTEGER;
    character_count
INTEGER;
    location_count
INTEGER;
    session_count
INTEGER;
BEGIN
SELECT COUNT(*)
INTO campaign_count
FROM campaign;
SELECT COUNT(*)
INTO character_count
FROM character;
SELECT COUNT(*)
INTO location_count
FROM location;
SELECT COUNT(*)
INTO session_count
FROM session;

RAISE
NOTICE '';
    RAISE
NOTICE '=== Database Reset Complete ===';
    RAISE
NOTICE 'Campaigns: %', campaign_count;
    RAISE
NOTICE 'Characters: %', character_count;
    RAISE
NOTICE 'Locations: %', location_count;
    RAISE
NOTICE 'Sessions: %', session_count;
    RAISE
NOTICE '';

    IF
campaign_count = 0 AND character_count = 0 AND location_count = 0 AND session_count = 0 THEN
        RAISE NOTICE '✓ All tables successfully emptied!';
ELSE
        RAISE WARNING '⚠ Some tables still contain data!';
END IF;
END $$;
