package nf3.ouite.repository

import nf3.ouite.model.Space
import org.springframework.data.jpa.repository.JpaRepository

interface SpaceRepository: JpaRepository <Space, Long>
