#!/bin/bash

# Initialize demo data for local development
# Run this script after starting the application to populate the database

set -e

echo "🎮 Shadowrun GM - Data Remover"
echo "======================================="
echo ""

# SQL file location
RESET_SQL="db/reset.sql"

# Check if SQL file exists
if [ ! -f "$RESET_SQL" ]; then
    echo "❌ Error: $RESET_SQL not found!"
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
docker compose exec -T postgres psql -U shadowrun -d shadowrun < "$RESET_SQL"

if [ $? -eq 0 ]; then
    echo ""
    echo "✅ Data reset successfully!"
    echo ""
else
    echo ""
    echo "❌ Error resetting data!"
    exit 1
fi
