#!/bin/bash

# Initialize demo data for local development
# Run this script after starting the application to populate the database

set -e

echo "🎮 Shadowrun GM - Demo Data Initializer"
echo "======================================="
echo ""

# SQL file location
INIT_SQL="db/init.sql"

# Check if SQL file exists
if [ ! -f "$INIT_SQL" ]; then
    echo "❌ Error: $INIT_SQL not found!"
    exit 1
fi

# Check if Docker Compose is running
if ! docker compose ps postgres | grep -q "Up"; then
    echo "❌ Error: PostgreSQL container is not running!"
    echo "   Start it with: ./mvnw spring-boot:run -Dspring-boot.run.profiles=DEV"
    exit 1
fi

echo "📊 Database: shadowrun"
echo "🐳 Using Docker Compose postgres service"
echo ""
echo "⏳ Initializing demo data..."
echo ""

# Execute the SQL file using docker compose exec
docker compose exec -T postgres psql -U shadowrun -d shadowrun < "$INIT_SQL"

if [ $? -eq 0 ]; then
    echo ""
    echo "✅ Demo data initialized successfully!"
    echo ""
    echo "📝 Summary:"
    echo "   - 1 Campaign: Seattle 2082: Neon Shadows"
    echo "   - 3 Player Characters: Razor, Hex, Whisper"
    echo "   - 4 NPCs: Mr. Johnson, Doc Vega, Sledge, IC-SPIDER"
    echo "   - 3 Locations: The Neon Dragon, Redmond Barrens, Renraku Arcology"
    echo "   - 2 Session logs"
    echo ""
else
    echo ""
    echo "❌ Error initializing demo data!"
    exit 1
fi
