-- Initialize demo data for local development
-- This file is executed via spring.flyway.init-sqls

-- Campaign
INSERT INTO campaign (title, description, status, created_at, updated_at)
VALUES ('Seattle 2082: Neon Shadows',
        'The shadows of Seattle run deep with corporate intrigue, street gangs, and the ever-present hum of the Matrix. A group of runners must navigate this cyberpunk dystopia to survive.',
        'ACTIVE',
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP);

-- Player Characters
INSERT INTO character (title, race, name, type, archetype, status, created_at, updated_at)
VALUES ('The Blade', 'Human', 'Razor', 'PLAYER', 'Street Samurai', 'Active', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Digital Ghost', 'Elf', 'Hex', 'PLAYER', 'Decker', 'Active', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Shadow Walker', 'Human', 'Whisper', 'PLAYER', 'Face', 'Active', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- NPCs
INSERT INTO character (title, race, name, type, archetype, status, created_at, updated_at)
VALUES ('Corporate Handler', 'Human', 'Mr. Johnson', 'NPC', 'Corporate Fixer', 'Active', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Street Doc', 'Dwarf', 'Doc Vega', 'NPC', 'Street Physician', 'Active', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Gang Leader', 'Orc', 'Sledge', 'NPC', 'Gang Boss', 'Hostile', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('Matrix Security', 'AI', 'IC-SPIDER', 'NPC', 'Intrusion Countermeasure', 'Active', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Locations
INSERT INTO location (title, body, created_at, updated_at)
VALUES ('The Neon Dragon',
        'A bustling bar in Downtown Seattle, known as a neutral meeting ground for runners and fixers. Neon lights flicker through the smoky air, and the bartender knows everyone''s business.',
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP),
       ('Redmond Barrens',
        'The lawless slums on the outskirts of Seattle. Gang territories, abandoned buildings, and desperate people make this one of the most dangerous areas in the sprawl.',
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP),
       ('Renraku Arcology',
        'A massive corporate structure housing thousands of workers and executives. Security is tight, but the Matrix presence is even tighter.',
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP);

-- Sessions (linked to the campaign)
INSERT INTO session (campaign_id, session_number, log, created_at, updated_at)
VALUES ((SELECT id FROM campaign WHERE title = 'Seattle 2082: Neon Shadows' LIMIT 1),
        1,
        'Session 1: The team met Mr. Johnson at The Neon Dragon. Job: Extract a prototype cyberdeck from Renraku Arcology. Payment: 50,000¥. Razor negotiated an advance. Planning phase began.',
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP),
       ((SELECT id FROM campaign WHERE title = 'Seattle 2082: Neon Shadows' LIMIT 1),
        2,
        'Session 2: The team gathered intel on Renraku security. Hex successfully mapped the Matrix topology. Whisper charmed a low-level security guard for access codes. Infiltration scheduled for next session.',
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP);
