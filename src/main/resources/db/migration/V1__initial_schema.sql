-- Campaigns
CREATE TABLE campaign (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

-- Campaign Scenes
CREATE TABLE campaign_scene (
    id BIGSERIAL PRIMARY KEY,
    campaign_id BIGINT NOT NULL REFERENCES campaign(id) ON DELETE CASCADE,
    sequence INTEGER NOT NULL,
    title VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    UNIQUE(campaign_id, sequence)
);

-- Campaign Scene Sections
CREATE TABLE campaign_scene_section (
    id BIGSERIAL PRIMARY KEY,
    scene_id BIGINT NOT NULL REFERENCES campaign_scene(id) ON DELETE CASCADE,
    sequence INTEGER NOT NULL,
    title VARCHAR(255) NOT NULL,
    body TEXT,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    UNIQUE(scene_id, sequence)
);

-- Characters (Players and NPCs)
CREATE TABLE character (
    id BIGSERIAL PRIMARY KEY,
    gender VARCHAR(2),
    alias varchar(100),
    metatype VARCHAR(50),
    name VARCHAR(255) NOT NULL,
    type VARCHAR(20) NOT NULL,
    archetype VARCHAR(100),
    status VARCHAR(50),
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

-- Character Properties (JSON storage)
CREATE TABLE character_property (
    id BIGSERIAL PRIMARY KEY,
    character_id BIGINT NOT NULL REFERENCES character(id) ON DELETE CASCADE,
    sequence INTEGER NOT NULL,
    key VARCHAR(100) NOT NULL,
    type VARCHAR(50) NOT NULL,
    value JSONB NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    UNIQUE(character_id, sequence)
);

-- Campaign Scene Section Dialogs
CREATE TABLE campaign_scene_section_dialog (
    id BIGSERIAL PRIMARY KEY,
    scene_section_id BIGINT NOT NULL REFERENCES campaign_scene_section(id) ON DELETE CASCADE,
    character_id BIGINT REFERENCES character(id) ON DELETE SET NULL,
    sequence INTEGER NOT NULL,
    dialog TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    UNIQUE(scene_section_id, sequence)
);

-- Campaign Scene Section Properties (JSON storage)
CREATE TABLE campaign_scene_section_property (
    id BIGSERIAL PRIMARY KEY,
    scene_id BIGINT NOT NULL REFERENCES campaign_scene(id) ON DELETE CASCADE,
    sequence INTEGER NOT NULL,
    key VARCHAR(100) NOT NULL,
    type VARCHAR(50) NOT NULL,
    value JSONB NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    UNIQUE(scene_id, sequence)
);

-- Sessions
CREATE TABLE session (
    id BIGSERIAL PRIMARY KEY,
    campaign_id BIGINT NOT NULL REFERENCES campaign(id) ON DELETE CASCADE,
    session_number INTEGER NOT NULL,
    log TEXT,
    session_date DATE NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    UNIQUE(campaign_id, session_number)
);

-- Locations
CREATE TABLE location (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    type VARCHAR(50),
    location VARCHAR(100),
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

-- Location Properties (JSON storage)
CREATE TABLE location_property (
    id BIGSERIAL PRIMARY KEY,
    location_id BIGINT NOT NULL REFERENCES location(id) ON DELETE CASCADE,
    sequence INTEGER NOT NULL,
    key VARCHAR(100) NOT NULL,
    type VARCHAR(50) NOT NULL,
    value JSONB NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    UNIQUE(location_id, sequence)
);

-- Indexes for performance
CREATE INDEX idx_campaign_scene_campaign ON campaign_scene(campaign_id);
CREATE INDEX idx_campaign_scene_section_scene ON campaign_scene_section(scene_id);
CREATE INDEX idx_campaign_scene_section_dialog_section ON campaign_scene_section_dialog(scene_section_id);
CREATE INDEX idx_campaign_scene_section_dialog_character ON campaign_scene_section_dialog(character_id);
CREATE INDEX idx_campaign_scene_section_property_scene ON campaign_scene_section_property(scene_id);
CREATE INDEX idx_session_campaign ON session(campaign_id);
CREATE INDEX idx_character_character_property ON character_property(character_id);
CREATE INDEX idx_location_property_location ON location_property(location_id);
CREATE INDEX idx_character_type ON character(type);
