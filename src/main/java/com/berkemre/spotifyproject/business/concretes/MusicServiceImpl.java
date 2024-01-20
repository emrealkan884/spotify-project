package com.berkemre.spotifyproject.business.concretes;

import com.berkemre.spotifyproject.business.abstracts.MusicService;
import com.berkemre.spotifyproject.business.dtos.music.requests.AddMusicRequest;
import com.berkemre.spotifyproject.business.dtos.music.requests.UpdateMusicRequest;
import com.berkemre.spotifyproject.business.dtos.music.responses.AddMusicResponse;
import com.berkemre.spotifyproject.business.dtos.music.responses.GetAllMusicsResponse;
import com.berkemre.spotifyproject.business.dtos.music.responses.GetMusicResponse;
import com.berkemre.spotifyproject.business.dtos.music.responses.UpdateMusicResponse;
import com.berkemre.spotifyproject.core.exceptions.types.BusinessException;
import com.berkemre.spotifyproject.entities.Music;
import com.berkemre.spotifyproject.repositories.MusicRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MusicServiceImpl implements MusicService {
  private final MusicRepository musicRepository;
  private final ModelMapper modelMapper;

  @Override
  public AddMusicResponse add(AddMusicRequest request) {
    Music music = modelMapper.map(request, Music.class);
    music.setId(UUID.randomUUID());
    music.setCreatedDate(LocalDateTime.now());
    Music createdMusic = musicRepository.save(music);
    AddMusicResponse response = modelMapper.map(createdMusic, AddMusicResponse.class);
    return response;
  }

  @Override
  public UpdateMusicResponse update(UUID id, UpdateMusicRequest request) {
    checkIfMusicExists(id);
    Music music = modelMapper.map(request, Music.class);
    music.setId(id);
    music.setUpdatedDate(LocalDateTime.now());
    Music updatedMusic = musicRepository.save(music);
    UpdateMusicResponse response = modelMapper.map(updatedMusic, UpdateMusicResponse.class);
    return response;
  }

  @Override
  public void delete(UUID id) {
    checkIfMusicExists(id);
    musicRepository.deleteById(id);
  }

  @Override
  public GetMusicResponse getById(UUID id) {
    checkIfMusicExists(id);
    Music music = musicRepository.findById(id).orElseThrow();
    GetMusicResponse response = modelMapper.map(music, GetMusicResponse.class);
    return response;
  }

  @Override
  public List<GetAllMusicsResponse> getAll() {
    List<Music> musics = musicRepository.findAll();
    List<GetAllMusicsResponse> response =
        musics.stream().map(music -> modelMapper.map(music, GetAllMusicsResponse.class)).toList();
    return response;
  }

  @Override
  public List<Music> getForByIdsNative(List<UUID> ids) {
    for (UUID id : ids) {
      checkIfMusicExists(id);
    }
    return musicRepository.getForByIdsNative(ids);
  }

  @Override
  public Music getForByIdNative(UUID id) {
    checkIfMusicExists(id);
    return musicRepository.getForByIdNative(id);
  }

  @Override
  public int countLikesById(UUID id) {
    checkIfMusicExists(id);
    return musicRepository.findById(id).orElseThrow().getLikeCount();
  }

  private void checkIfMusicExists(UUID id) {
    if (!musicRepository.existsById(id))
      throw new BusinessException("Boyle bir muzik mevcut degil");
  }
}
