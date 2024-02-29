package nf3.Ouite.repository

import nf3.Ouite.Model.Artifact
import org.springframework.data.jpa.repository.JpaRepository

interface ArtifactRepository : JpaRepository<Artifact, Long> {
}