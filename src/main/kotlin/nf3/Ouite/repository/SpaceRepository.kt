package nf3.Ouite.repository

import nf3.Ouite.Model.Space
import org.springframework.data.jpa.repository.JpaRepository

interface SpaceRepository: JpaRepository <Space, Long> {
}