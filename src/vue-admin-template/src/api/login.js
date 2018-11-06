import request from '@/utils/request'

export function login(username, password) {
  return request({
    method: 'post',
    data: {
      cmd: 'signin',
      username,
      password
    }
  })
}

export function getInfo() {
  return request({
    method: 'post',
    data: {
      cmd: 'getUserInfo'
    }
  })
}

export function logout() {
  return request({
    method: 'post',
    data: {
      cmd: 'logout'
    }
  })
}
