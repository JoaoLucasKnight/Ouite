package nf3.ouite.repository

import nf3.ouite.model.Artifact
import org.springframework.data.jpa.repository.JpaRepository

interface ArtifactRepository : JpaRepository<Artifact, Long>